package com.tir.alb.babystep.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tir.alb.babystep.R;

/**
 * Created by erioncuni on 12/04/2017.
 */

public class Fragment_CallCenter extends Fragment {
    private static final String TAG = "FragmentRegister";
    Button CallNumber,Brexit;
    TextView Label;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_callcenter, null);

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = preferences.edit();
        Label = (TextView)v.findViewById(R.id.txt_label_number);
        CallNumber = (Button)v.findViewById(R.id.btn_call);
        Brexit = (Button)v.findViewById(R.id.btn_brexit);


        CallNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));
/*
                if (ActivityCompat.checkSelfPermission(MainLogin.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                */
                startActivity(callIntent);
            }
        });


        Brexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();

            }
        });




        return v;

    }











}
