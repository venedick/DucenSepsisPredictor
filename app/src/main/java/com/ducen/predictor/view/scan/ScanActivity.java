package com.ducen.predictor.view.scan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ducen.predictor.view.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.ResponseHandlerInterface;
import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.EMDKResults;
import com.symbol.emdk.barcode.BarcodeManager;
import com.symbol.emdk.barcode.ScanDataCollection;
import com.symbol.emdk.barcode.Scanner;
import com.symbol.emdk.barcode.ScannerConfig;
import com.symbol.emdk.barcode.ScannerException;
import com.symbol.emdk.barcode.ScannerInfo;
import com.symbol.emdk.barcode.StatusData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import okhttp3.internal.http2.Header;

public class ScanActivity extends Activity implements EMDKManager.EMDKListener, Scanner.DataListener, Scanner.StatusListener, BarcodeManager.ScannerConnectionListener {

    private EMDKManager emdkManager = null;
    private BarcodeManager barcodeManager = null;
    private Scanner scanner = null;

    private TextView barCodeStatus = null;
    private TextView barCodeData = null;

    private List<ScannerInfo> deviceList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        barCodeStatus = (TextView) findViewById(R.id.barCodeStatus);
        barCodeData = (TextView) findViewById(R.id.barCodeData);

        EMDKResults results = EMDKManager.getEMDKManager(getApplicationContext(), this);
        if (results.statusCode != EMDKResults.STATUS_CODE.SUCCESS) {
            barCodeStatus.setText("EMDKManager object request failed!");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (emdkManager != null) {
            barcodeManager = (BarcodeManager) emdkManager.getInstance(EMDKManager.FEATURE_TYPE.BARCODE);

            if (barcodeManager != null) {
                barcodeManager.addConnectionListener(this);
            }


            scanner.triggerType = Scanner.TriggerType.HARD;
            ScannerConfig config = null;
            try {
                config = scanner.getConfig();
            } catch (ScannerException e) {
                e.printStackTrace();
            }
            assert config != null;
            config.decoderParams.ean8.enabled = true;
            config.decoderParams.ean13.enabled = true;
            config.decoderParams.code39.enabled = true;
            config.decoderParams.code128.enabled = true;
            try {
                scanner.setConfig(config);
            } catch (ScannerException e) {
                e.printStackTrace();
            }
            initScanner();
        }
    }

    private void initScanner() {
    }

    @Override
    public void onOpened(EMDKManager emdkManager) {
        barCodeStatus.setText("EMDK open success!");

        this.emdkManager = emdkManager;

        barcodeManager = (BarcodeManager) emdkManager.getInstance(EMDKManager.FEATURE_TYPE.BARCODE);

        if (barcodeManager != null) {
            barcodeManager.addConnectionListener(this);
        }

        if (scanner == null) {
            initScanner();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deInitScanner();

        if (barcodeManager != null) {
            barcodeManager.removeConnectionListener((BarcodeManager.ScannerConnectionListener) this);
            barcodeManager = null;
        }

        if (emdkManager != null) {
            emdkManager.release();
            emdkManager = null;

        }
    }

    @Override
    public void onClosed() {
        if (emdkManager != null) {

            if (barcodeManager != null) {
                barcodeManager.removeConnectionListener((BarcodeManager.ScannerConnectionListener) this);
                barcodeManager = null;
            }

            emdkManager.release();
            emdkManager = null;
        }
        barCodeStatus.setText("EMDK closed unexpectedly! Please close and restart the application.");

    }

    @Override
    public void onData(ScanDataCollection scanDataCollection) {


    }

    @Override
    public void onStatus(StatusData statusData) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        deInitScanner();

        if (barcodeManager != null) {
            barcodeManager.removeConnectionListener(this);
            barcodeManager = null;
            deviceList = null;
        }

        if (emdkManager != null) {
            emdkManager.release(EMDKManager.FEATURE_TYPE.BARCODE);
        }
    }

    private void deInitScanner() {
        if (scanner != null) {

            try {

                scanner.cancelRead();
                scanner.disable();

            } catch (Exception e) {

                barCodeStatus.setText(e.getMessage());
            }

            try {
                scanner.removeDataListener(this);
                scanner.removeStatusListener(this);

            } catch (Exception e) {

                barCodeStatus.setText(e.getMessage());
            }

            try {
                scanner.release();
            } catch (Exception e) {

                barCodeStatus.setText(e.getMessage());
            }

            scanner = null;
        }
    }

    private class AsyncDataUpdate extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            return params[0];
        }

        protected void onPostExecute(String result) {

            if (result != null) {
                String url = "https://r2.smarthealthit.org/Device?udi=" + result + "&_format=json";

                RequestHandle requestHandle = new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {

                    @Override
                    public void onPreProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                        barCodeStatus.setText("Checking match..");
                    }

                    @Override
                    public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                        // default action is to do nothing...
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        String response = new String(responseBody);
                        String reference = "";

                        try {
                            JSONObject reader = new JSONObject(response);
                            reference = reader.getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getJSONObject("patient").getString("reference");

                            /*Intent intent = new Intent(HomeActivity.this, PatientInfo.class);
                            intent.putExtra("PID", reference);
                            startActivity(intent);
                            finish();*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                            barCodeData.append(e.toString());
                            //NEED TO CREATE DIALOG FRAGMENT
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
            }
        }
    }

    public void onConnectionChange(ScannerInfo scannerInfo, BarcodeManager.ConnectionState connectionState) {

        String status;
        String scannerName = "";

        String statusExtScanner = connectionState.toString();
        String scannerNameExtScanner = scannerInfo.getFriendlyName();

        if (deviceList.size() != 0) {
            int scannerIndex = 0;
            scannerName = deviceList.get(scannerIndex).getFriendlyName();
        }

        if (scannerName.equalsIgnoreCase(scannerNameExtScanner)) {

            switch(connectionState) {
                case CONNECTED:
                    deInitScanner();
                    initScanner();
                    scanner.triggerType = Scanner.TriggerType.HARD;
                    ScannerConfig config = null;
                    try {
                        config = scanner.getConfig();
                    } catch (ScannerException e) {
                        e.printStackTrace();
                    }
                    config.decoderParams.ean8.enabled = true;
                    config.decoderParams.ean13.enabled = true;
                    config.decoderParams.code39.enabled = true;
                    config.decoderParams.code128.enabled = true;
                    try {
                        scanner.setConfig(config);
                    } catch (ScannerException e) {
                        e.printStackTrace();
                    }
                    break;
                case DISCONNECTED:
                    deInitScanner();
                    break;
            }

            status = scannerNameExtScanner + ":" + statusExtScanner;
            /*new AsyncStatusUpdate().execute(status);*/
        }
        else {
            String statusString = "";
            status =  statusString + " " + scannerNameExtScanner + ":" + statusExtScanner;
            /*new AsyncStatusUpdate().execute(status);*/
        }
    }
}

