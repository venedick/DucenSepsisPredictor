package com.ducen.predictor.r4.rest.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ducen.predictor.view.MainActivity;
import com.ducen.predictor.view.home.defaultdata.ServerAddress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class R4APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //.baseUrl(getServerAddressFromFile())
                    .baseUrl(ServerAddress.R4_BASE_URL.toString())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    private static String getServerAddressFromFile(Context context){
        String address = "";
        try {
            File testFile = new File(context.getExternalFilesDir(null), "ducensepsis.txt");
            Log.d("R4APIClient", "Get server address from file");
            String line,server;
            if (testFile != null) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(testFile));
                    while ((line = reader.readLine()) != null) {
                        address = line.split(" ")[4];
                        Log.d("R4APIClient", "Server Address : " + address);
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
