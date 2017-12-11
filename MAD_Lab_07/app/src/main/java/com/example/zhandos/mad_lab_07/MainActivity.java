package com.example.zhandos.mad_lab_07;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);

        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        retrieveData();
    }

    private void retrieveData() {
        Ion.with(this)
                .load("https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=15b515acd22548f284d7e54f7150ea34")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            processData(result);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    }

    private void processData(String data) throws JSONException {
        JSONObject jsonObject = new JSONObject(data);
        JSONArray articles = jsonObject.getJSONArray("articles");

        List<Article> articlesList = new ArrayList<>();
        for (int i = 0; i < articles.length(); ++i) {
            JSONObject article = articles.getJSONObject(i);
            String author = article.getString("author");
            String title = article.getString("title");
            String description = article.getString("description");
            String imageUrl = article.getString("urlToImage");
            String publishedAt = article.getString("publishedAt");

            Article newArt = new Article(author, title, description, imageUrl, publishedAt);
            Log.d("BBC", newArt.toString());
            articlesList.add(newArt);
        }
        showArticles(articlesList);
    }


    private void showArticles(List<Article> aList) {
        MyAdapter ma = new MyAdapter(this, aList);
        myRecyclerView.setAdapter(ma);
    }
}
