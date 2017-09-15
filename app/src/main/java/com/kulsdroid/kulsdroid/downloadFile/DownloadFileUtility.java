package com.kulsdroid.kulsdroid.downloadFile;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.kulsdroid.kulsdroid.R;
import com.kulsdroid.kulsdroid.application.MyApplication;
import com.kulsdroid.kulsdroid.utils.CommonUtils;

import java.io.File;

/**
 * Created by sit27 on 9/14/2017.
 */

public class DownloadFileUtility {

    private static NotificationManager mNotifyManager;
    private static NotificationCompat.Builder mBuilder;
    private static int intNotificationId = 8001;

    public interface OnDownloadFileListener {
        public void onSuccess(File file);

        public void onFailure(Exception e);

        public void onProgress(int progress);
    }

    public static void downloadFile(String url, String filePath, final OnDownloadFileListener mOnDownloadFileListener) {

        mNotifyManager = (NotificationManager) MyApplication.getContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(MyApplication.getContext());

        mBuilder.setContentTitle("Download material")
                .setContentText("Download in progress")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setProgress(100, 0, true);

        mNotifyManager.notify(intNotificationId, mBuilder.build());
        CommonUtils.showToast(CommonUtils.getString(R.string.downloading));

        Ion.with(MyApplication.getContext())
                .load(CommonUtils.removeWhiteSpaceFromURL(url))
                .progress(new ProgressCallback() {
                    @Override
                    public void onProgress(long downloaded, long total) {
                        mOnDownloadFileListener.onProgress(
                                CommonUtils.findPercentage(downloaded, total));
                    }
                })
                .write(new File(filePath))
                .setCallback(new FutureCallback<File>() {
                    @Override
                    public void onCompleted(Exception e, File file) {

                        if (e == null && file.exists()) {

                            mBuilder.setContentText(CommonUtils.getString(R.string.downloadCompleted))
                                    .setProgress(0, 0, false);
                            mNotifyManager.notify(intNotificationId, mBuilder.build());
                            mOnDownloadFileListener.onSuccess(file);
                            CommonUtils.showToast(CommonUtils.getString(R.string.downloadCompleted));

                        } else {

                            mBuilder.setContentText(CommonUtils.getString(R.string.downloadFailure))
                                    .setProgress(0, 0, false);
                            mNotifyManager.notify(intNotificationId, mBuilder.build());
                            mOnDownloadFileListener.onFailure(e);
                            CommonUtils.showToast(CommonUtils.getString(R.string.downloadFailure));
                        }

                    }
                });
    }

}
