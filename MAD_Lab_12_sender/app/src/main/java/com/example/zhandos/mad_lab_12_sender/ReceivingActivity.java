package com.example.zhandos.mad_lab_12_sender;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ReceivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        checkPermission();
        TelephonyManager telephonyManager = (TelephonyManager)
                this.getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = telephonyManager.getLine1Number();
        Log.d("RECEIVE", "Line1 number # " + phoneNumber);
        String portNumber = phoneNumber.substring(phoneNumber.length() - 4, phoneNumber.length());
        Log.d("RECEIVE", "Line1 number # " + portNumber);

        registerReceiver(new DownloadReceiver(), new IntentFilter("com.example.zhandos.downloadintentservice"));
    }

    private void checkPermission() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(ReceivingActivity.this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    234);

        }
    }

    public class DownloadReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("RECEIVE", intent.getStringExtra("message"));

            createNotification(intent.getStringExtra("message"));
        }
    }

    private void createNotification(String filepath) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("file", filepath);
        PendingIntent pending = PendingIntent.getActivity(
                this, (int) System.currentTimeMillis(), intent, 0);

        Notification.Builder builder = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentIntent(pending);

        Notification notify = builder.build();
        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify((int) System.currentTimeMillis(), notify);

    }
}
