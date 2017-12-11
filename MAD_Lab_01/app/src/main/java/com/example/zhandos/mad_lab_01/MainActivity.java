package com.example.zhandos.mad_lab_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button addButton;
    Button subtractButton;
    Button divideButton;
    Button multButton;
    Button equalButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(this);
        divideButton = (Button) findViewById(R.id.divideButton);
        divideButton.setOnClickListener(this);
        multButton = (Button) findViewById(R.id.multButton);
        multButton.setOnClickListener(this);

        equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                break;
            case R.id.subtractButton:
                break;
            case R.id.divideButton:
                break;
            case R.id.multButton:
                break;
            case R.id.equalButton:
                break;
            default:
                Log.d("debug", "button clicked");
                break;
        }
    }
}
