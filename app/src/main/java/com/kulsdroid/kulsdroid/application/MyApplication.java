package com.kulsdroid.kulsdroid.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by KulsDroid on 9/15/2017.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
