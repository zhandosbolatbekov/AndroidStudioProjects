package com.example.zhandos.mad_lab_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DictionaryActivity extends AppCompatActivity {

    ListView wordListView;
    List<String> words = new ArrayList<String>();
    Map<String, String> definition = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        readWordsFromFile();

        
        wordListView = (ListView) findViewById(R.id.wordListView);
        wordListView.setAdapter(adapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word = words.get(i);
                Toast.makeText(getApplicationContext(),
                        (String) definition.get(word),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void readWordsFromFile() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.dictionary));
        // reading words
        for(int i = 0; i < 10; ++i) {
            String word = scan.nextLine();
            words.add(word);
        }
        // reading corresponding definitions
        for(int i = 0; i < 10; ++i) {
            String def = scan.nextLine();
            definition.put(words.get(i), def);
        }
        scan.close();
    }
}
