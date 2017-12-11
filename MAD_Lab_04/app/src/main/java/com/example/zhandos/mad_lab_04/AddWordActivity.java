package com.example.zhandos.mad_lab_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddWordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etWord;
    EditText etDefinition;
    Button bnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = (EditText) findViewById(R.id.etWord);
        etDefinition = (EditText) findViewById(R.id.etDefinition);
        bnAdd = (Button) findViewById(R.id.bnAdd);
        bnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bnAdd) {
            if (etWord.getText().length() > 0 && etDefinition.getText().length() > 0) {
                String word = etWord.getText().toString();
                String definition = etDefinition.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("word", word);
                intent.putExtra("definition", definition);

                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
