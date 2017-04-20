package com.tir.alb.babystep.datase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;




public enum DatabaseManager {
    INSTANCE;


    private SQLiteDatabase db;
    private boolean isDbClosed =true;
    DBHandler dbHelper;
    public void init(Context context) {
        dbHelper = new DBHandler(context);
        if(isDbClosed){
            isDbClosed =false;
            this.db = dbHelper.getWritableDatabase();
        }

    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public boolean isDatabaseClosed(){
        return isDbClosed;
    }

    public void closeDatabase(){
        if(!isDbClosed && db != null){
            isDbClosed =true;
            db.close();
            dbHelper.close();
        }
    }





    public int getCustomQuery()
    {
        Cursor resultSet = db.rawQuery("Select * from TutorialsPoint",null);
        resultSet.moveToFirst();
        String username = resultSet.getString(0);
        String password = resultSet.getString(1);
        return 0;
    }







    /************************************************************/


















/*
    public int getpjata(int prodId) {
        String selectQuery = "SELECT " + DBHandler.DISHES_ID
                +" FROM " + DBHandler.TABLE_MENU_DISHES
                +" WHERE " + DBHandler.DISHES_ID + "=" + prodId;

        System.out.println("eeeeeeeeeeeeeddddddsaasasdasd"+selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);

        int quantity = 0;
        if (cursor.moveToFirst()) {
            quantity = cursor.getInt(0);
        }
        cursor.close();

        return quantity;
    }
    */




}