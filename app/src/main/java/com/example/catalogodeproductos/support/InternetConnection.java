package com.example.catalogodeproductos.support;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetConnection {

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected = false;

        if (connectivityManager != null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            try {
                isConnected = networkInfo.getState() == NetworkInfo.State.CONNECTED;
            } catch (Exception e) {
                isConnected = networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable();
            }
        }
        return isConnected;
    }
}
