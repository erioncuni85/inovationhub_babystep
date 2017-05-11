package com.tir.alb.babystep.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.tir.alb.babystep.R;
import com.tir.alb.babystep.adapter.NewsAdapter;
import com.tir.alb.babystep.model.Article;
import com.tir.alb.babystep.model.News;
import com.tir.alb.babystep.rest.API;
import com.tir.alb.babystep.rest.APIClient;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by erioncuni on 12/04/2017.
 */

public class Fragment_Rezervime extends Fragment {
    private static final String TAG = "FragmentRegister";


    String ApiKey;
    RecyclerView recyclerView;
    Gson gson;
    Dialog dialog;
    private NewsAdapter adapter;
   // List<Model_Lecture_Data> lecture;
    List<Article> article;
    public Fragment_Rezervime() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_rezervime, null);

        gson = new GsonBuilder().create();

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
        adapter = new NewsAdapter(getActivity(), article);
        recyclerView.setAdapter(adapter);
       // loading();
        get_all_news();
        return v;

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    public void get_all_news() {


        final API api =
                APIClient.createAPI().create(API.class);

        Call<News> totclient = api.news();
        totclient.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, retrofit2.Response<News> response) {
                //dialog.dismiss();
                // Log.d(TAG, "Succes:" + response.body().isError());
                JSONObject obj = new JSONObject();
                System.out.println("AllLectures:" + gson.toJson(response.body()));

                if(!gson.toJson(response.body()).equalsIgnoreCase("null"))
                {
                    String Status = gson.toJson(response.body().getStatus());
                    String Surce = gson.toJson(response.body().getSource());


                    article = response.body().getArticles();
                    Toast.makeText(getContext(),"Source: "+Surce,Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new NewsAdapter(getActivity(),article));
                    adapter.notifyDataSetChanged();


                }else{
                    Toast.makeText(getContext(),"Sesioni juaj ka skaduar ju duhet te rilogoheni",Toast.LENGTH_LONG).show();
                }


                // recyclerView.setAdapter(new CategoryAdapter(category, R.layout.adapter_category, getActivity()));

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                //dialog.dismiss();
            }
        });
    }



/*
    public void loading()
    {
        dialog  = new MaterialDialog.Builder(getActivity())
                .title("Duke ngarkuar te dhenat!")
                .content("Ju lutem prisni...")
                .progress(true, 0)
                .show();
    }
    */



}

