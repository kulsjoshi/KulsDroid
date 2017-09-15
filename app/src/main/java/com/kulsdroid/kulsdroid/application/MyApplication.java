package com.kulsdroid.kulsdroid.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by sit27 on 9/15/2017.
 */

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();
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
