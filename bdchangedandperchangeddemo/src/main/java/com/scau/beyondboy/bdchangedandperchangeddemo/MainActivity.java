package com.scau.beyondboy.bdchangedandperchangeddemo;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNetWorkJobWork();
        accessPrivateFile();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setNetWorkJobWork(){
        JobScheduler jobScheduler=(JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo=new JobInfo.Builder(1,new ComponentName(this,MyJobService.class))
                //当链接任何一种网络
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY )
                //当插上了电源充电
                .setRequiresCharging(true).build();
        //满足上面了两种情况就会执行这个任务
        jobScheduler.schedule(jobInfo);
    }

    //在android 7.0会引起崩溃
    public void accessPrivateFile(){
        //SharedPreferences preference=getSharedPreferences("test",MODE_WORLD_WRITEABLE);
        try {
            FileOutputStream fos = openFileOutput("test", Context.MODE_WORLD_WRITEABLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG,"异常问题");
        }
    }
}
