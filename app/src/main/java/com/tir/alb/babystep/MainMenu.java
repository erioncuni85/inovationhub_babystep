package com.tir.alb.babystep;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.tir.alb.babystep.fragment.Fragment_CallCenter;
import com.tir.alb.babystep.fragment.Fragment_Rezervime;
import com.tir.alb.babystep.fragment.Fragment_Sherbime;

public class MainMenu extends AppCompatActivity {

    Button Menu1,Menu2,Menu3;
    FrameLayout First;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Menu1 = (Button)findViewById(R.id.btn_menu1);
        Menu2 = (Button)findViewById(R.id.btn_menu2);
        Menu3 = (Button)findViewById(R.id.btn_menu3);
        First = (FrameLayout) findViewById(R.id.first);

        f_starter();

        Menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_rezervime();
            }
        });
        Menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_sherbime();
            }
        });
        Menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f_callcenter();
            }
        });


    }

    public void f_starter() {

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'><b>Sherbime</b></font>"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_Sherbime sherbime = new Fragment_Sherbime();
        fragmentTransaction.add(R.id.first, sherbime, "Sherbime");
        fragmentTransaction.commit();
    }

    public void f_sherbime() {

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'><b>Sherbime</b></font>"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_Sherbime sherbime = new Fragment_Sherbime();
        Bundle data = new Bundle();//Use bundle to pass data
       // data.putString("emri", "Pippo");//put string, int, etc in bundle with a key value
       // data.putString("mbiemri", "Pluto");//iemput string, int, etc in bundle with a key value


        data.putString("emri", "Erion");
        data.putString("mbiemri", "Cuni");
        data.putString("url", "http://www.venmond.com/demo/vendroid/img/avatar/big.jpg");
        data.putLong("phoneNumber", 123466);


        sherbime.setArguments(data);//Finally set argument bundle to fragment
        fragmentTransaction.replace(R.id.first, sherbime, "Sherbime");
        fragmentTransaction.commit();
    }

    public void f_rezervime() {

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'><b>Rezervime</b></font>"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_Rezervime rezervime = new Fragment_Rezervime();
        fragmentTransaction.replace(R.id.first, rezervime, "Rezervime");
        fragmentTransaction.commit();
    }

    public void f_callcenter() {

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'><b>Call Center</b></font>"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_CallCenter callCenter = new Fragment_CallCenter();
        fragmentTransaction.replace(R.id.first, callCenter, "Call Center");
        fragmentTransaction.commit();
    }


}
