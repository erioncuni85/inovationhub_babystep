package com.tir.alb.babystep.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Erion on 1/6/2016.
 */
public class SaveData {
    Context ctx;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SaveData(Context ctx1){
        this.ctx = ctx1;
        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = preferences.edit();
    }


    public void SaveCardId(int card_id){
        editor.putInt("paf_card_id", card_id);
        editor.commit();
    }

    public void SaveFirstTimeSelectLanguage(String firsttime){
        editor.putString("paf_first_time_language", firsttime);
        editor.commit();
    }

    public String get_first_time_language(){
        return preferences.getString("paf_first_time_language", "");
    }
    public void SavePhoneNumber(String phonenumber){
        editor.putString("paf_phonenumber", phonenumber);
        editor.commit();
    }
    public String get_phonenumber(){
        return preferences.getString("paf_phonenumber", "");
    }
    public void SaveLoginData(int id, String lastname, String firstname, String email, String password){
        editor.putInt("paf_user_id", id);
        editor.putString("paf_lastname",lastname);
        editor.putString("paf_firstname",firstname);
        editor.putString("paf_email",email);
        editor.putString("paf_password",password);
        editor.commit();
    }

    public void SaveFirstName(String firstname){
        editor.putString("paf_firstname",firstname);
        editor.commit();
    }

    public void SaveLanguageChoice(String language){
        editor.putString("paf_language",language);
        editor.commit();
    }
    public String get_paf_language(){
        return preferences.getString("paf_language", "");
    }


    public void SaveLastName(String lastname){
        editor.putString("paf_lastname",lastname);
        editor.commit();
    }


    public void SaveAddressId(String address_id){
        editor.putString("paf_user_address_id", address_id);
        editor.commit();
    }
    public void SaveAddressOrigin(String origin){
        editor.putString("paf_user_address_origin", "");
        editor.commit();
    }

    public void SaveAddressLatLon(double lat,double lon){
        editor.putFloat("paf_lat", (float) lat);
        editor.putFloat("paf_lon", (float) lon);
        editor.commit();
    }

    public Float getAddressLat(){
        return preferences.getFloat("paf_lat", 0);
    }
    public Float getAddressLon(){
        return preferences.getFloat("paf_lon", 0);
    }
    public int getCardId(){
        return preferences.getInt("paf_card_id", -1);
    }

    public String get_paf_address_id(){
        return preferences.getString("paf_user_address_id", "");
    }
    public String get_paf_address_origin(){
        return preferences.getString("paf_user_address_origin", "");
    }

    public int get_paf_user_id(){
        return preferences.getInt("paf_user_id", -1);
    }
    public String get_paf_lastname(){
        return preferences.getString("paf_lastname", "");
    }

    public String get_paf_firstname(){
        return preferences.getString("paf_firstname", "");
    }
    public String get_paf_phone(){
        return preferences.getString("paf_phone", "");
    }
    public String get_paf_email(){
        return preferences.getString("paf_email", "");
    }
    public String get_paf_password(){
        return preferences.getString("paf_password", "");
    }

    public void SaveFoliaToken(String token){
        editor.putString("folia_user_token",token);
        editor.commit();
    }


    public void Saveorigin(String address_id){
        editor.putString("paf_origin", address_id);
        editor.commit();
    }

    public String get_origin(){
        return preferences.getString("paf_origin", "");
    }


    public void ClearAll(){
        editor.clear();
        editor.commit();
    }
}
