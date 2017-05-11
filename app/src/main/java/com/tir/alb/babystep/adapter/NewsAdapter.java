package com.tir.alb.babystep.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tir.alb.babystep.R;
import com.tir.alb.babystep.activity.NewsDetails;
import com.tir.alb.babystep.model.Article;
import com.tir.alb.babystep.model.News;
import com.tir.alb.babystep.utils.ItemClickListener;
import com.tir.alb.babystep.utils.SaveData;

import java.util.List;

/**
 * Created by Almotech on 5/11/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    //private Context mContext;
    //private String[] mList;
    Typeface custom_font;
    private List<Article> feedItemList;
    private Context mContext;
    int id_category;
    Gson gson;
    SaveData saveData;
    String ApiKey;

    public NewsAdapter(Context context, List<Article> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_structure, parent, false);
        return new NewsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.ViewHolder holder, final int position) {
        //holder.titleTextView.setText(mList[position]);
        saveData = new SaveData(mContext);
        gson = new GsonBuilder().create();

        final Article feedItem = feedItemList.get(position);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {

                } else {

                    Intent infoIntent = new Intent(mContext, NewsDetails.class); //ActivityOptionsCompat options = ActivityOptionsCompat.
                    infoIntent.putExtra("category_id", feedItem.getTitle()+"");
                    infoIntent.putExtra("category_name", feedItem.getDescription());
                    infoIntent.putExtra("category_name", feedItem.getUrlToImage());
                    infoIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(infoIntent);



                }
            }



        });


        holder.NewsTitle.setText(feedItemList.get(position).getTitle());
        holder.NewsDescrition.setText(feedItemList.get(position).getDescription());









        Glide.with(mContext)
                .load(feedItemList.get(position).getUrlToImage())
                //.centerCrop()
                // .placeholder(R.drawable.ic_porosiicon)
                .crossFade()
                .into(holder.NewsImage);



        // System.out.println("vlerat e array : ");



    }



    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener{
        LinearLayout moviesLayout;
        TextView NewsTitle,NewsDescrition;
        ImageView NewsImage;
        private ItemClickListener clickListener;


        public ViewHolder(View itemView) {
            super(itemView);
            NewsImage = (ImageView) itemView.findViewById(R.id.news_image);
            NewsTitle = (TextView) itemView.findViewById(R.id.textView2);
            NewsDescrition = (TextView) itemView.findViewById(R.id.textView);



            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            //title.setText("Test");

            //http://autov1.xnet.al/restaurant/admin/attachment/menu/original/69dfa5c1b72404bd238b3991f409f4441774931984.jpg


        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }










}