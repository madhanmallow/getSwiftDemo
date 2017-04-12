package com.mallow.getswiftdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Company: Mallow Technology
 * Created by bhagya on 23/11/15.
 */
public class GSUtilities {
    private static String TAG = "CXUtilities";
    /**
     * Method to check the network connection
     *
     * @return Return the connection status
     */
    public static Boolean checkNetworkConnection(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo wifiInfo, mobileInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiInfo.getState() == NetworkInfo.State.CONNECTED || mobileInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        } catch (Exception exception) {
            Log.d(TAG, "CheckConnectivity Exception: " + exception.getMessage());
        }

        return false;
    }
}