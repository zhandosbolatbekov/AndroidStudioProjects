package com.example.zhandos.mad_lab_04;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DictionaryActivity extends AppCompatActivity {

    ListView wordListView;
    List<String> words = new ArrayList<String>();
    Map<String, String> definition = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        readWordsFromFile();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.word_list_item,
                R.id.wordTextView,
                words
        );
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
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ":");

            String word = tokenizer.nextToken();
            String def = tokenizer.nextToken();
            words.add(word);
            definition.put(word, def);
        }
        scan.close();

        readFromFile(getApplicationContext());
    }

    private void readFromFile(Context context) {

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    StringTokenizer tokenizer = new StringTokenizer(receiveString, ":");
                    String word = tokenizer.nextToken();
                    String def = tokenizer.nextToken();
                    words.add(word);
                    definition.put(word, def);
                }

                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }
}
