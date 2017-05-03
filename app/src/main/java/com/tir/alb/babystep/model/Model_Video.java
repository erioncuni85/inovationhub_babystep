package com.tir.alb.babystep.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AlmotechHome on 4/1/2017.
 */

public class Model_Video {

    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Model_Video_Data> data;
    // private data data;

    /*  public Markers(boolean error, String message) {
         this.error = error;
         this.message = message;
     }
 */
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Model_Video_Data> getData() {
        return data;
    }

    public void setData(List<Model_Video_Data> data) {
        this.data = data;
    }

}
