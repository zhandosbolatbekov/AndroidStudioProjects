package com.example.zhandos.mad_lab_04_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EmailDetailsActivity extends AppCompatActivity {

    Email email;

    TextView tvSender;
    TextView tvSubject;
    TextView tvCc;
    TextView tvDate;
    TextView tvTitle;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_details);

        Intent intent = getIntent();
        email = (Email) intent.getSerializableExtra("email");

        tvSender = (TextView) findViewById(R.id.tvSenderDetail);
        tvSubject = (TextView) findViewById(R.id.tvSubjectDetail);
        tvCc = (TextView) findViewById(R.id.tvCc);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);

        tvSender.setText(email.getSender());
        tvSubject.setText(email.getSubject());
        tvCc.setText(email.getCc());
        tvDate.setText(email.getDate());
        tvTitle.setText(email.getTitle());
        tvContent.setText(email.getContent());
    }
}
