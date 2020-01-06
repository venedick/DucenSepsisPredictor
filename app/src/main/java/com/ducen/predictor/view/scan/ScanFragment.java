//package com.ducen.predictor.view.scan;
//
//
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.TextView;
//
////EMDK
//import com.symbol.emdk.EMDKManager;
//import com.symbol.emdk.barcode.BarcodeManager;
//import com.symbol.emdk.barcode.ScanDataCollection;
//import com.symbol.emdk.barcode.Scanner;
//import com.symbol.emdk.EMDKResults;
//import com.symbol.emdk.EMDKManager.EMDKListener;
//import com.symbol.emdk.EMDKManager.FEATURE_TYPE;
//import com.symbol.emdk.barcode.BarcodeManager.ConnectionState;
//import com.symbol.emdk.barcode.BarcodeManager.ScannerConnectionListener;
//import com.symbol.emdk.barcode.ScannerConfig;
//import com.symbol.emdk.barcode.ScannerException;
//import com.symbol.emdk.barcode.ScannerInfo;
//import com.symbol.emdk.barcode.ScannerResults;
//import com.symbol.emdk.barcode.ScanDataCollection.ScanData;
//import com.symbol.emdk.barcode.Scanner.DataListener;
//import com.symbol.emdk.barcode.Scanner.StatusListener;
//import com.symbol.emdk.barcode.Scanner.TriggerType;
//import com.symbol.emdk.barcode.StatusData.ScannerStates;
//import com.symbol.emdk.barcode.StatusData;
//
//import com.ducen.predictor.view.R;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class ScanFragment extends Fragment implements EMDKListener, DataListener, StatusListener, ScannerConnectionListener {
//
//    private EMDKManager emdkManager = null;
//    private BarcodeManager barcodeManager = null;
//    private Scanner scanner = null;
//
//    private TextView barCodeStatus = null;
//    private TextView barCodeData = null;
//
//    private List<ScannerInfo> deviceList = null;
//    private int scannerIndex = 0;
//    private String statusString = "";
//
//    private static final String TAG = "ScanFragment";
//
//    public ScanFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d(TAG, "onCreate: start");
//
//        if(emdkManager == null){
//            EMDKResults results = EMDKManager.getEMDKManager(getActivity().getApplicationContext(), this);
//
//
//            if (results.statusCode != EMDKResults.STATUS_CODE.SUCCESS) {
//                barCodeStatus.setText("EMDKManager object request failed!");
//
//            }
//        }
//
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        Log.d(TAG, "onCreateView: start");
//
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_scan, container, false);
//
//        barCodeStatus = view.findViewById(R.id.barCodeStatus);
//        barCodeData = view.findViewById(R.id.barCodeData);
//
//
//        return view;
//
//
//    }
//
//    @Override
//    public void onOpened(EMDKManager emdkManager) {
//        Log.d(TAG, "onOpened");
//
//        barCodeStatus.setText("EMDK open success!");
//        this.emdkManager = emdkManager;
//
//        barcodeManager = (BarcodeManager) emdkManager.getInstance(FEATURE_TYPE.BARCODE);
//
//        if (barcodeManager != null) {
//            barcodeManager.addConnectionListener(this);
//        }
//        if (scanner == null) {
//            initScanner();
//        }
//    }
//
//    @Override
//    public void onClosed() {
//        if (emdkManager != null) {
//            Log.d(TAG, "onClosed: start");
//
//            if (barcodeManager != null) {
//                barcodeManager.removeConnectionListener((ScannerConnectionListener) this);
//                barcodeManager = null;
//            }
//
//            emdkManager.release();
//            emdkManager = null;
//        }
//        barCodeStatus.setText("EMDK closed unexpectedly! Please close and restart the application.");
//    }
//
//    @Override
//    public void onData(ScanDataCollection scanDataCollection) {
//        if ((scanDataCollection != null) && (scanDataCollection.getResult() == ScannerResults.SUCCESS)) {
//            ArrayList<ScanData> scanData = scanDataCollection.getScanData();
//            for (ScanData data : scanData) {
//
//                String dataString = "UDI: " + data.getData();
//                Log.d(TAG, "onData: " + dataString);
//                barCodeData.setText(dataString);
//                new AsyncDataUpdate().execute(data.getData());
//            }
//        }
//    }
//
//    @Override
//    public void onStatus(StatusData statusData) {
//        ScannerStates state = statusData.getState();
//        switch (state) {
//            case IDLE:
//                statusString = "Scanner is enabled and idle...";
//                new AsyncStatusUpdate().execute(statusString);
//                try {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    scanner.read();
//                } catch (ScannerException e) {
//                    statusString = e.getMessage();
//                    new AsyncStatusUpdate().execute(statusString);
//                }
//
//                break;
//            case WAITING:
//                statusString = "Scanner is waiting for trigger press...";
//                new AsyncStatusUpdate().execute(statusString);
//                break;
//            case SCANNING:
//                statusString = "Scanning...";
//                new AsyncStatusUpdate().execute(statusString);
//                break;
//            case DISABLED:
//                statusString = statusData.getFriendlyName() + " is disabled.";
//                new AsyncStatusUpdate().execute(statusString);
//                break;
//            case ERROR:
//                statusString = "An error has occurred.";
//                new AsyncStatusUpdate().execute(statusString);
//                break;
//            default:
//                break;
//        }
//    }
//
//    public void onConnectionChange(ScannerInfo scannerInfo, ConnectionState connectionState) {
//        Log.d(TAG, "onConnectionChange: start");
//        String status;
//        String scannerName = "";
//
//        String statusExtScanner = connectionState.toString();
//        String scannerNameExtScanner = scannerInfo.getFriendlyName();
//
//        if (deviceList.size() != 0) {
//            scannerName = deviceList.get(scannerIndex).getFriendlyName();
//        }
//
//        if (scannerName.equalsIgnoreCase(scannerNameExtScanner)) {
//
//            switch (connectionState) {
//                case CONNECTED:
//                    deInitScanner();
//                    initScanner();
//                    scanner.triggerType = TriggerType.HARD;
//                    ScannerConfig config = null;
//                    try {
//                        config = scanner.getConfig();
//                    } catch (ScannerException e) {
//                        e.printStackTrace();
//                    }
//                    config.decoderParams.ean8.enabled = true;
//                    config.decoderParams.ean13.enabled = true;
//                    config.decoderParams.code39.enabled = true;
//                    config.decoderParams.code128.enabled = true;
//                    try {
//                        scanner.setConfig(config);
//                    } catch (ScannerException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case DISCONNECTED:
//                    deInitScanner();
//                    break;
//            }
//
//            status = scannerNameExtScanner + ":" + statusExtScanner;
//            new AsyncStatusUpdate().execute(status);
//        } else {
//            status = statusString + " " + scannerNameExtScanner + ":" + statusExtScanner;
//            new AsyncStatusUpdate().execute(status);
//        }
//        Log.d(TAG, "onConnectionChange: end");
//
//    }
//
//    private void initScanner() {
//        Log.d(TAG, "initScanner: start");
//
//        if (scanner == null) {
//
//
//            scanner = barcodeManager.getDevice(BarcodeManager.DeviceIdentifier.DEFAULT);
//
//            if (scanner != null) {
//
//                scanner.addDataListener(this);
//                scanner.addStatusListener(this);
//
//                try {
//                    Log.d(TAG, "initScanner: pre scanner.enable();");
//                    scanner.enable();
//                    Log.d(TAG, "initScanner: post scanner.enable();");
//
//                } catch (ScannerException e) {
//
//                    barCodeStatus.setText(e.getMessage());
//                }
//            } else {
//                barCodeStatus.setText("Failed to initialize the scanner device.");
//            }
//        }
//        Log.d(TAG, "initScanner: end");
//
//    }
//
//    private void deInitScanner() {
//        Log.d(TAG, "deInitScanner: start");
//
//        if (scanner != null) {
//            Log.d(TAG, "deInitScanner: disable");
//            try {
//
//                scanner.cancelRead();
//                scanner.disable();
//
//            } catch (Exception e) {
//
//                barCodeStatus.setText(e.getMessage());
//            }
//
//            try {
//                scanner.removeDataListener(this);
//                scanner.removeStatusListener(this);
//
//            } catch (Exception e) {
//
//                barCodeStatus.setText(e.getMessage());
//            }
//
//            try {
//                scanner.release();
//            } catch (Exception e) {
//
//                barCodeStatus.setText(e.getMessage());
//            }
//
//            scanner = null;
//        }
//
//        Log.d(TAG, "deInitScanner: end");
//
//    }
//
//    private class AsyncDataUpdate extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            return params[0];
//        }
//
//        /*protected void onPostExecute(String result) {
//
//            if (result != null)
//            {
//                String url = "https://r2.smarthealthit.org/Device?udi=" + result + "&_format=json";
//
//                RequestHandle requestHandle = new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onPreProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
//                        barCodeStatus.setText("Checking match..");
//                    }
//
//                    @Override
//                    public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
//                        // default action is to do nothing...
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                        String response = new String(responseBody);
//                        String reference = "";
//
//                        try {
//                            JSONObject reader = new JSONObject(response);
//                            reference = reader.getJSONArray("entry").getJSONObject(0).getJSONObject("resource").getJSONObject("patient").getString("reference");
//
//                            Intent intent = new Intent(getActivity(), PatientActivity.class);
//                            intent.putExtra("PID", reference);
//                            startActivity(intent);
//                            finish();
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            barCodeData.append(e.toString());
//                            //NEED TO CREATE DIALOG FRAGMENT
//                        }
//
//
//
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        //NEED TO CREATE DIALOG FRAGMENT
//                    }
//                });
//            }
//        }*/
//    }
//
//    private class AsyncStatusUpdate extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            return params[0];
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//            barCodeStatus.setText(result);
//        }
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.d(TAG, "onDestroyView: ");
//        try {
//            if (scanner != null) {
//                Log.d(TAG, "onDestroyView: disable scanner");
//                // releases the scanner hardware resources for other application
//                // to use. You must call this as soon as you're done with the
//                // scanning.
//                scanner.removeDataListener(this);
//                scanner.removeStatusListener(this);
//                scanner.disable();
//                scanner = null;
//            }
//            if (emdkManager != null) {
//                Log.d(TAG, "onDestroyView: realese EMDK");
//
//                // Clean up the objects created by EMDK manager
//                emdkManager.release();
//                emdkManager = null;
//
//            }
//
//        } catch (ScannerException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
