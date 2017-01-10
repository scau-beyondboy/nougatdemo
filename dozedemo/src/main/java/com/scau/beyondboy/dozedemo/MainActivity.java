package com.scau.beyondboy.dozedemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPermissionDialog();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean isIgnoringBatteryOptimizations(){
        Context context=this;
        String packageName = context.getPackageName();
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        return pm.isIgnoringBatteryOptimizations(packageName);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void ShowPermissionDialog(){
        Intent intent = new Intent();
        Context context=this;
        String packageName = context.getPackageName();
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //是否列入Doze和待机模式白名单
        if (pm.isIgnoringBatteryOptimizations(packageName)){
            Log.d(TAG,"isIgnoringBatteryOptimizations TRUE");
        } else {
            Log.d(TAG,"isIgnoringBatteryOptimizations FALSE");
            intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
        }
        context.startActivity(intent);
    }
}
