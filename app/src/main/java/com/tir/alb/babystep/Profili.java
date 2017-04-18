package com.tir.alb.babystep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

public class Profili extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profili);


        Intent in = getIntent();

        Bundle b = in.getExtras();

        String nameString = b.getString("fullname");

        long phoneNumberLong = b.getLong("phoneNumber");

        Toast.makeText(getApplicationContext(),"Emri: "+nameString,Toast.LENGTH_LONG).show();

    }
}
