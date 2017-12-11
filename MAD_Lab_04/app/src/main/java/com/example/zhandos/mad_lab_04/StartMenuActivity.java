package com.example.zhandos.mad_lab_04;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class StartMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ADD_WORD_REQ_CODE = 1234;

    Button bnPlayGame;
    Button bnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        bnPlayGame = (Button) findViewById(R.id.bnPlayGame);
        bnPlayGame.setOnClickListener(this);

        bnAddWord = (Button) findViewById(R.id.bnAddWord);
        bnAddWord.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnPlayGame:
                Intent intent1 = new Intent(this, DictionaryActivity.class);
                startActivity(intent1);
                break;
            case R.id.bnAddWord:
                Intent intent2 = new Intent(this, AddWordActivity.class);
                startActivityForResult(intent2, ADD_WORD_REQ_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_WORD_REQ_CODE && resultCode == RESULT_OK) {
            String word = data.getStringExtra("word");
            String definition = data.getStringExtra("definition");
            writeToFile((word + ":" + definition).toString(), getApplicationContext());
        }
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
