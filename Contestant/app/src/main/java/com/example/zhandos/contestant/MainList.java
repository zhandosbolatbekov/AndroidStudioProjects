package com.example.zhandos.contestant;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainList extends AppCompatActivity {

    public List<Integer> resourceIds = Arrays.asList(1, 6, 12, 23, 25, 63, 64, 93, 2, 90);
    public List<Resource> resourceList = new ArrayList<>();

    private final String USERNAME = "Zhandos";
    private final String API_KEY = "9c1c06124318e59e89f063704d45655d6d5aa00c";
    private final String URL_CONTEST_LIST = "http://clist.by/api/v1/contest";
    private final String URL_RESOURCE_LIST =  "http://clist.by/api/v1/resource/set";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        recyclerView = (RecyclerView) findViewById(R.id.main_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        retrieveData();
    }

    private void retrieveData() {

        String resUrl = URL_RESOURCE_LIST + "/";
        for (int i = 0; i < resourceIds.size(); ++i) {
            resUrl += resourceIds.get(i).toString();
            if(i + 1 < resourceIds.size())
                resUrl += ";";
        }
        resUrl += "/?username=" + USERNAME + "&api_key=" + API_KEY;
        Ion.with(this)
                .load(resUrl)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            processResourceList(result);
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
        String url = URL_CONTEST_LIST + "/?username=" + USERNAME + "&api_key=" + API_KEY;
        Ion.with(this)
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            processContestList(result);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
    }

    private void processContestList(String data) throws JSONException {
        JSONObject jsonObject = new JSONObject(data);
        JSONArray contests = jsonObject.getJSONArray("objects");

        List<Contest> contestList = new ArrayList<>();
        for (int i = 0; i < contests.length(); ++i) {
            JSONObject contest = contests.getJSONObject(i);
            int id = Integer.parseInt(contest.getString("id").toString());
            String startTime = contest.getString("start");
            String endTime = contest.getString("end");
            String duration = contest.getString("duration");
            String href = contest.getString("href");
            String name = contest.getString("event");

            JSONObject resourceObject = new JSONObject(contest.getString("resource"));
            int resId = Integer.parseInt(resourceObject.getString("id").toString());
            String resName = resourceObject.getString("name");
            Resource resource = new Resource(resId, resName);

            Contest newContest = new Contest(id, startTime, endTime, duration, name, href, resource);

            //Log.d("DEBUG", "SIZE=" + resourceList.size());
            //Log.d("CONTEST", newContest.getResource().toString());
            /*
            int contains = 0;
            for(int j = 0; j < resourceList.size(); ++j)
                if(resourceList.get(j).getId() == newContest.getResource().getId()) {
                    contains = 1;
                    break;
                }
            if(contains == 1) {
                contestList.add(newContest);
            }
            */
            contestList.add(newContest);
        }

        showContestList(contestList);
    }

    private void showContestList(List<Contest> list) {
        MainListAdapter myAdapter = new MainListAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
    }

    private void processResourceList(String data) throws JSONException {
        JSONArray resources = new JSONObject(data).getJSONArray("objects");
        for(int i = 0; i < resources.length(); ++i) {
            JSONObject resource = resources.getJSONObject(i);
            int id = Integer.parseInt(resource.get("id").toString());
            String name = resource.get("name").toString();
            Log.d("DEBUG", resource.toString());
            resourceList.add(new Resource(id, name));
        }
    }
}
