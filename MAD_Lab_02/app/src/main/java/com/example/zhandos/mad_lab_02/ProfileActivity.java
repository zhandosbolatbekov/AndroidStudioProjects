package com.example.zhandos.mad_lab_02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ArrayList<Person> profiles = new ArrayList<>();
    ImageView profileIV;
    TextView lastNameTV;
    TextView firstNameTV;
    TextView telephoneTV;
    TextView email1TV;
    TextView email2TV;
    TextView addressTV;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initProfiles();
        initView();

        setProfile(0);
    }

    private void initProfiles() {
        profiles.add(new Person(
                "http://www.newsshare.in/wp-content/uploads/2017/04/Miniclip-8-Ball-Pool-Avatar-7.png",
                "Bolatbekov",
                "Zhandos",
                "+77774074100",
                "zhabo.fm@gmail.com",
                "jab_9777@mail.ru",
                "Almaty, Mamyr 2"));
        profiles.add(new Person(
                "http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-business-bear.png",
                "Nuptebek",
                "Elibay",
                "+77021239876",
                "elibay@gmail.com",
                "nuptebek@gmail.com",
                "Almaty, Tastak"));
        profiles.add(new Person(
                "http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-ginger-guy.png",
                "Ormanov",
                "Meirkhan",
                "+77051010101",
                "ormanovmeirkhan@gmail.com",
                "taraz@mail.ru",
                "Almaty, Tole Bi 232"));
    }

    private void initView() {
        profileIV = (ImageView) findViewById(R.id.profileImageView);
        lastNameTV = (TextView) findViewById(R.id.lastNameTV);
        firstNameTV = (TextView) findViewById(R.id.firstNameTV);
        telephoneTV = (TextView) findViewById(R.id.mobileTV);
        email1TV = (TextView) findViewById(R.id.emailTV);
        email2TV = (TextView) findViewById(R.id.email2TV);
        addressTV = (TextView) findViewById(R.id.addressTV);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case -1:
                        setProfile(0);
                        break;
                    case R.id.profile1RB:
                        setProfile(0);
                        break;
                    case R.id.profile2RB:
                        setProfile(1);
                        break;
                    case R.id.profile3RB:
                        setProfile(2);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void setProfile(int id) {
        switch (id) {
            case 0:
                profileIV.setImageDrawable(getResources().getDrawable(R.drawable.profile1));
                break;
            case 1:
                profileIV.setImageDrawable(getResources().getDrawable(R.drawable.profile2));
                break;
            case 2:
                profileIV.setImageDrawable(getResources().getDrawable(R.drawable.profile3));
                break;
        }
        Person showing = profiles.get(id);
        lastNameTV.setText(showing.getLastName());
        firstNameTV.setText(showing.getFirstName());
        telephoneTV.setText(showing.getMobile());
        email1TV.setText(showing.getEmail1());
        email2TV.setText(showing.getEmail2());
        addressTV.setText(showing.getAddress());
    }
}
