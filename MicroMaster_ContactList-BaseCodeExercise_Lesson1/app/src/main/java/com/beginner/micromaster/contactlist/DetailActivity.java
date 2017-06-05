package com.beginner.micromaster.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvLastName = (TextView) findViewById(R.id.tvLastName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvPhoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        //TODO: get the rest of contact parameters
        String name = b.getString("name");
        String lastname = b.getString("lastName");
        String email = b.getString("email");
        String phoneNumber = b.getString("phoneNumber");

        //TODO: once you have all the values for a contact add them to the views
        tvName.setText(getString(R.string.msg_name, name));
        tvLastName.setText(getString(R.string.msg_last_name, lastname));
        tvEmail.setText(getString(R.string.msg_email, email));
        tvPhoneNumber.setText(getString(R.string.msg_phone_number, phoneNumber));
    }
}
