package com.example.zhandos.mad_lab_06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    String[] urls = {"https://img1.goodfon.ru/wallpaper/big/a/69/kartinka-3d-dikaya-koshka.jpg",
            "https://static.businessinsider.com/image/48756cc1796c7aa60049416b/image.jpg",
            "http://minionomaniya.ru/wp-content/uploads/2015/11/minion-tankist-kartinka.jpg"};

    String[] names = {"image1", "image2", "image3"};

    @BindView(R.id.tvLink)
    EditText tvLink;
    @BindView(R.id.coolButton)
    BootstrapButton coolButton;
    @BindView(R.id.imageView)
    BootstrapCircleThumbnail imageView;
    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, names);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvLink.setText(urls[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        loadURL(urls[0]);
    }

    private void loadURL(String url) {
        Picasso.with(this).load(url).fit().centerCrop().into(imageView);
    }

    @OnClick(R.id.coolButton)
    public void onViewClicked() {
        String url = tvLink.getText().toString();
        loadURL(url);
        YoYo.with(Techniques.Bounce).duration(500).repeat(3).playOn(coolButton);
    }
}
