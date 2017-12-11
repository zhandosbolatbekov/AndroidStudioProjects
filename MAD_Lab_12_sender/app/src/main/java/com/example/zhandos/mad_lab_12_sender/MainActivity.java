package com.example.zhandos.mad_lab_12_sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBtnTouch(View view) {
        startActivity(new Intent(getApplicationContext(), SendingActivity.class));
    }

    public void receiveBtnTouch(View view) {
        startActivity(new Intent(getApplicationContext(), ReceivingActivity.class));
    }
}
