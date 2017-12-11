package com.example.zhandos.mad_lab_12_sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendingActivity extends AppCompatActivity {

    EditText phoneEt, messageEt;
    Button sendMessageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);

        phoneEt = (EditText) findViewById(R.id.phoneEt);
        messageEt = (EditText) findViewById(R.id.msgEt);
        sendMessageBtn = (Button) findViewById(R.id.sendMsgBtn);
        sendMessageBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String phoneNo = phoneEt.getText().toString();
                String msg = messageEt.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent",
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            }
        });
    }
}
