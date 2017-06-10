package com.example.mac.moviemanager.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mac.moviemanager.R;
import com.example.mac.moviemanager.adapters.MovieRecyclerViewAdapter;
import com.example.mac.moviemanager.models.Movie;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {

    @BindView(R.id.rvMovies) RecyclerView rvMovies;

    Unbinder unbinder;

    MovieRecyclerViewAdapter adapter;
    private List<Movie> movies;

    public UpcomingFragment() {
        movies = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(llm);

        adapter = new MovieRecyclerViewAdapter(getContext(), movies);
        rvMovies.setAdapter(adapter);

        new MyAsync().execute();

        return view;
    }

    private void initializeData() throws Exception {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/upcoming?api_key=041002b871245f52b51405f0f613270e&language=en-US&page=1")
                .build();

        JSONObject Jobject = new JSONObject(client.newCall(request).execute().body().string().toString());
        JSONArray Jarray = Jobject.getJSONArray("results");
        for(int i = 0; i < Jarray.length(); ++i) {
            JSONObject object = Jarray.getJSONObject(i);
            String id = object.getString("id");
            String title = object.getString("title");
            String overview = object.getString("overview");
            float voteAverage = Float.valueOf(object.getString("vote_average"));
            float voteCount = Float.valueOf(object.getString("vote_count"));
            String posterPath = object.getString("poster_path");
            String backdropPath = object.getString("backdrop_path");
            Movie m = new Movie(id, title, overview,
                    voteAverage, voteCount, posterPath, backdropPath);
            Log.d("Entity_movie", m.toString());
            movies.add(m);

            Log.d("Json_object", Jobject.toString());
        }

        /*
        movies.add(new Movie("277834", "Rings", "Julia (Matilda Lutz) becomes worried about her boyfriend, Holt (Alex Roe) when he explores the dark urban legend of a mysterious videotape said to kill the watcher seven days after viewing. She sacrifices herself to save her boyfriend and in doing so makes a horrifying discovery: there is a \\\"movie within the movie\\\" that no one has ever seen before.", 0f, 0, "/uwNNLJULvTQfgc3PBZAY92EOJQO.jpg", "/91WPDonXsxRzi7AcfedKM3p3NFU.jpg"));
        movies.add(new Movie("121856", "The Great Wall", "The story of an elite force making a last stand for humanity on the world’s most iconic structure.", 0f, 0, "/hm0Z5tpRlSzPO97U5e2Q32Y0Xrb.jpg", "/yESCAoZkaxZ2AMiHojl9jYYd9zD.jpg"));
        movies.add(new Movie("330459", "Patriots Day", "An account of Boston Police Commissioner Ed Davis's actions in the events leading up to the 2013 Boston Marathon bombing and the aftermath, which includes the city-wide manhunt to find the terrorists behind it.", 0f, 0, "/gd4SDPZIdVRAxUolQ9ZCNXTkQUq.jpg", "/tiBL4PeaCPKGBz3qO4dJP2KzKop.jpg"));
        movies.add(new Movie("283366", "T2 Trainspotting", "First there was an opportunity......then there was a betrayal. Twenty years have gone by. Much has changed but just as much remains the same. ", 0f, 0, "/A84pxL5z86KbV9u8GAK2mVOoXK.jpg", "/dxJynNxoG6jRttYPoXOGx7OWJvq.jpg"));
        */
    }

    private class MyAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                initializeData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
