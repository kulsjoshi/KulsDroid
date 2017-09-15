package com.kulsdroid.kulsdroid.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.kulsdroid.kulsdroid.R;
import com.kulsdroid.kulsdroid.permission.Permission;

public class MainActivity extends ParentAppCompatActivity {

    Permission mPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mPermission = new Permission();
        mPermission.checkLocationPermission(mActivity, new Permission.OnPermissionRequest() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(mActivity, "granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRejected() {
                Toast.makeText(mActivity, "rejected", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
