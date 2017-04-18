package com.tir.alb.babystep.fragment;

import android.os.Bundle;
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

public class Fragment_Sherbime extends Fragment {
    private static final String TAG = "FragmentRegister";
    String DataName,DataSurname;
    TextView Name,Surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_sherbime, null);


        Bundle mBundle = getActivity().getIntent().getExtras();
        mBundle = getArguments();

        if(mBundle!=null){
            DataName=mBundle.getString("emri");
            DataSurname=mBundle.getString("mbiemri");

            Name = (TextView)v.findViewById(R.id.emri);
            Surname = (TextView)v.findViewById(R.id.mbiemri);


            if(DataName!=null && DataSurname!=null){
                Name.setText("Emri eshte: "+DataName);
                Surname.setText("Mbiemri eshte: "+DataSurname);
            }
        }




        return v;

    }











}
