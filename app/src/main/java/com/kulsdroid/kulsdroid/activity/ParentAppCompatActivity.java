package com.kulsdroid.kulsdroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sit27 on 9/15/2017.
 */

public class ParentAppCompatActivity extends AppCompatActivity {

    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
    }

    private void initialization(){
        mActivity = ParentAppCompatActivity.this;
    }
}
