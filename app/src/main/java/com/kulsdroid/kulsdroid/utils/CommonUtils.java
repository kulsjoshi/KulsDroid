package com.kulsdroid.kulsdroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.kulsdroid.kulsdroid.application.MyApplication;

/**
 * Created by sit27 on 9/15/2017.
 */

public class CommonUtils {

    /**
     * This function will remove white space from String from URLs.
     * @param url
     * @return
     */
    public static String removeWhiteSpaceFromURL(String url) {
        return url.replaceAll(" ", "%20");
    }

    /**
     * This function will check internet connection is available or not.
     * @return
     */
    public static boolean isInternetAvailable() {

        boolean result = false;

        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            result = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This function return string from string.xml file
     * @param stringId
     * @return
     */
    public static String getString(int stringId) {
        return MyApplication.getContext().getResources().getString(stringId);
    }

    /**
     * This function will return color id from color.xml file
     * @param colorId
     * @return
     */
    public static int getColor(int colorId) {
        return MyApplication.getContext().getResources().getColor(colorId);
    }

    /**
     * This function will find percentage from given data and will return it.
     * @param currentProgress
     * @param totalProgress
     * @return
     */
    public static int findPercentage(long currentProgress, long totalProgress) {
        return (int) ((currentProgress * 100) / totalProgress);
    }

    /**
     * This function will show toast in the application
     * @param message
     */
    public static void showToast(String message) {
        if (!message.isEmpty()) {
            Toast.makeText(MyApplication.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
