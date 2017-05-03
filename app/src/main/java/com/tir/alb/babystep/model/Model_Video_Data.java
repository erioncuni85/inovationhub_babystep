package com.tir.alb.babystep.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AlmotechHome on 4/1/2017.
 */

public class Model_Video_Data {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;



    public Model_Video_Data(int id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
