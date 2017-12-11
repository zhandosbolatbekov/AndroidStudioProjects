package com.example.zhandos.mad_lab_03_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Guess_the_meaning extends AppCompatActivity {

    TextView guessWord;
    ListView variantsListView;
    ArrayAdapter<String> adapter;
    List<String> words = new ArrayList<String>();
    List<String> variants = new ArrayList<String>();
    Map<String, String> definition = new HashMap<String, String>();
    int correctAnswerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_meaning);

        readWordsFromFile();

        guessWord = (TextView) findViewById(R.id.guessWordTextView);
        variantsListView = (ListView) findViewById(R.id.variantWordsListView);

        adapter = new ArrayAdapter<String>(
                this,
                R.layout.word_list_item,
                R.id.variantTextView,
                variants
        );
        variantsListView.setAdapter(adapter);
        variantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String result;
                if (correctAnswerIndex == i) {
                    result = "Correct";
                } else {
                    result = "Incorrect";
                }
                Toast.makeText(getApplicationContext(),
                        result,
                        Toast.LENGTH_SHORT).show();
            }
        });

        generateNewWord();
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

    public void generateNewWord() {
        shuffleWords();

        guessWord.setText(words.get(0));
        variants.clear();
        for(int i = 0; i < 4; ++i) {
            String word = words.get(i);
            variants.add(definition.get(word));
        }
        shuffleVariants();
        for(int i = 0; i < 4; ++i) {
            String def = variants.get(i);
            if(definition.get(guessWord.getText().toString()).equals(def)) {
                correctAnswerIndex = i;
            }
        }
    }

    private void shuffleWords() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = words.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String tmp = words.get(index);
            words.set(index, words.get(i));
            words.set(i, tmp);
        }
    }

    private void shuffleVariants() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = variants.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String tmp = variants.get(index);
            variants.set(index, variants.get(i));
            variants.set(i, tmp);
        }
    }

    public void generateNew(View view) {
        generateNewWord();
        adapter.notifyDataSetChanged();
    }
}
