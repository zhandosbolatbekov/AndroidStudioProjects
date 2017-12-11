package com.example.zhandos.mad_lab_05;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        updateUI();
    }

    private void updateUI() {

        //  create main linear layout
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        setContentView(ll, params);

        // create textView
        TextView tv = new TextView(this);
        tv.setText("HELLO");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(24);
        tv.setTextColor(getResources().getColor(R.color.colorPrimary));
        FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        tvParams.setMargins(0, 32, 0, 32);
        tv.setLayoutParams(tvParams);
        ll.addView(tv);

        // create table layout

        TableLayout tl = new TableLayout(this);
        TableLayout.LayoutParams params1 = new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        tl.setLayoutParams(params1);

        TableRow row = new TableRow(this);
        row.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));

        ImageButton ib1 = new ImageButton(this);
        ImageButton ib2 = new ImageButton(this);

        FrameLayout.LayoutParams ibParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        ib1.setImageResource(R.drawable.kz_flag);
        ib1.setScaleType(ImageButton.ScaleType.CENTER_CROP);
        ib1.setAdjustViewBounds(true);
        ib1.setLayoutParams(ibParams);
        row.addView(ib1);

        ib2.setImageResource(R.drawable.ru_flag);
        ib2.setScaleType(ImageButton.ScaleType.CENTER_CROP);
        ib2.setAdjustViewBounds(true);
        ib2.setLayoutParams(ibParams);
        row.addView(ib2);

        tl.addView(row);

        ll.addView(tl);
    }
}
