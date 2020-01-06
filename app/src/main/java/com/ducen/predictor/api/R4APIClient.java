package com.ducen.predictor.api;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class R4APIClient {

    private  Retrofit retrofit = null;

    private Context context = null;

    private String serverAddressFromSession = "";

    public R4APIClient(Context context) {
        this.context = context;
    }

    public R4APIClient(Context context, String serverAddressFromSession) {
        this.context = context;
        this.serverAddressFromSession = serverAddressFromSession;
    }

    public Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            if ("".equalsIgnoreCase(serverAddressFromSession)) {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(getServerAddressFromFile())
//                    .baseUrl(ServerAddress.R4_BASE_URL.toString())
                        .client(client)
                        .build();

            } else {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(serverAddressFromSession)
//                    .baseUrl(ServerAddress.R4_BASE_URL.toString())
                        .client(client)
                        .build();
            }
        }
        return retrofit;
    }

    private String getServerAddressFromFile(){
        String address = "";
        try {
            File testFile = new File(context.getExternalFilesDir(null), "ducensepsis.txt");
            String line,server;
            if (testFile != null) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(testFile));
                    while ((line = reader.readLine()) != null) {
                        address = line.split(" ")[4];
                    }
                    reader.close();
                } catch (Exception e) {
                    Log.e("R4APICLient", "Unable to read the file." + e.toString());
                }
            }

        } catch (Exception e) {
            Log.e("R4APICLient", "Unable to write to the file.");
        }

        return address;
    }


}
