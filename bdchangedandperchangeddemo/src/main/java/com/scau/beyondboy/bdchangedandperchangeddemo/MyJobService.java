package com.scau.beyondboy.bdchangedandperchangeddemo;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @Author: beyondboy
 * @Gmail: guoli.xgl@alibaba-inc.com
 * @Date: 2017-01-10
 * @Time: 08:30
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {

    private static final String TAG = MyJobService.class.getName();

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG,"开始工作");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG,"停止工作");
        return false;
    }


}
