package com.tir.alb.babystep.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.tir.alb.babystep.R;

/**
 * Created by erioncuni on 12/04/2017.
 */

public class Fragment_Sherbime extends Fragment {
    private static final String TAG = "FragmentRegister";
    String DataName,DataSurname,DataUrl;
    EditText Name,Surname;
    ImageView Imageee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_sherbime, null);


        Bundle mBundle = getActivity().getIntent().getExtras();
        mBundle = getArguments();

        if(mBundle!=null){
            DataName=mBundle.getString("emri");
            DataSurname=mBundle.getString("mbiemri");
            DataUrl=mBundle.getString("url");

            Name = (EditText)v.findViewById(R.id.name);
            Surname = (EditText)v.findViewById(R.id.surname);
            Imageee = (ImageView)v.findViewById(R.id.imageView2);

            Glide.with(this)
                    .load(DataUrl)
                    .centerCrop()
                    .placeholder(R.drawable.image_profile)
                    .crossFade()
                    .into(Imageee);

            /*
            Picasso.with(getContext())
                    .load(DataUrl)
                    .placeholder(R.drawable.image_profile)
                    .error(R.drawable.image_profile)
                    .resize(200, 200)
                    .centerCrop()
                    .rotate(1)
                    .into(Imageee);
            */

            if(DataName!=null && DataSurname!=null){
                Name.setText("Emri eshte: "+DataName);
                Surname.setText("Mbiemri eshte: "+DataSurname);
            }
        }




        return v;

    }











}
