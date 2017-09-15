package com.kulsdroid.kulsdroid.permission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.kulsdroid.kulsdroid.utils.CommonUtils;

import java.security.Permissions;

/**
 * Created by KulsDroid on 9/15/2017.
 */

public class Permission implements ActivityCompat.OnRequestPermissionsResultCallback{

    private static Permissions mPermissions;
    private OnPermissionRequest onPermissionRequest;
    public static final int REQUEST_FINE_LOCATION_PERMISSION = 1;
    public static final int REQUEST_READ_STORAGE_PERMISSION = 2;
    public static final int REQUEST_WRITE_STORAGE_PERMISSION = 3;
    public static final int REQUEST_READ_CONTACTS_PERMISSION = 4;
    public static final int REQUEST_WRITE_CONTACTS_PERMISSION = 5;
    public static final int REQUEST_CAMERA_PERMISSION = 6;
    public static final int REQUEST_READ_PHONE_STATE_PERMISSION = 7;
    public static final int REQUEST_CALL_PHONE_PERMISSION = 8;
    public static final int REQUEST_READ_SMS_PERMISSION = 9;
    public static final int REQUEST_SEND_SMS_PERMISSION = 10;
    public static final int REQUEST_RECEIVE_SMS_PERMISSION = 11;
    public static final int REQUEST_WRITE_SETTINGS = 12;
    public static final int REQUEST_RECORD_AUDIO = 13;

    //Get Single Instance of CommonUtils Class
    public static Permissions getInstance() {
        if (mPermissions == null) {
            mPermissions = new Permissions();
        }
        return mPermissions;
    }

    public interface OnPermissionRequest{
        public void onPermissionGranted();
        public void onPermissionRejected();
    }

    public void setInterface(OnPermissionRequest onPermissionRequest){
        this.onPermissionRequest = onPermissionRequest;
    }

    //Check for location permission
    public void checkLocationPermission(Activity mActivity, OnPermissionRequest onPermissionRequest) {

        setInterface(onPermissionRequest);

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow location permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_FINE_LOCATION_PERMISSION);

            this.onPermissionRequest.onPermissionRejected();

        } else {
            this.onPermissionRequest.onPermissionGranted();
        }
    }

    //Check for read storage permission
    public Boolean isReadStoragePermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow storage permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_STORAGE_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for write storage permission
    public Boolean isWriteStoragePermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow storage permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE_PERMISSION);


            return false;

        } else {
            return true;
        }
    }

    //Check for read contacts permission
    public Boolean isReadContactsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow contact permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    REQUEST_READ_CONTACTS_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for write contacts permission
    public Boolean isWriteContactsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow contact permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.WRITE_CONTACTS},
                    REQUEST_WRITE_CONTACTS_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for camera permission
    public Boolean isCameraPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow camera permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for read phone state permission
    public Boolean isReadPhoneStatePermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow read phone state permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    REQUEST_READ_PHONE_STATE_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for call phone permission
    public Boolean isCallPhonePermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow call permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for read sms permission
    public Boolean isReadSmsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow sms permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.READ_SMS},
                    REQUEST_READ_SMS_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for send sms permission
    public Boolean isSendSmsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow sms permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.SEND_SMS},
                    REQUEST_SEND_SMS_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for receive sms permission
    public Boolean isReceiveSmsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow sms permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    REQUEST_RECEIVE_SMS_PERMISSION);
            return false;

        } else {
            return true;
        }
    }

    //Check for write settings permission
    public Boolean isWriteSettingsPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.WRITE_SETTINGS)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow write settings permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.WRITE_SETTINGS},
                    REQUEST_WRITE_SETTINGS);
            return false;

        } else {
            return true;
        }
    }

    //Check for record audio permission
    public Boolean isRecordAudioPermissionGranted(Activity mActivity) {

        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            CommonUtils.showToast("Please allow record audio permission.");

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO);
            return false;

        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_FINE_LOCATION_PERMISSION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    onPermissionRequest.onPermissionGranted();

                } else {

                    onPermissionRequest.onPermissionRejected();

                }
                return;
            }

        }


    }
}
