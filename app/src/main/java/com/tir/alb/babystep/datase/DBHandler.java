package com.tir.alb.babystep.datase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 20;
	public static final String DATABASE_NAME = "pafalV";

	public static final String PREF_TABLE_ORDERS = "paf_prefered";

	public static final String PREF_CART_KEY_ID = "id";
	public static final String PREF_CART_KEY_NAME = "name";
	public static final String PREF_CART_KEY_DESCRIPTION = "description";
	public static final String PREF_CART_KEY_PRICE = "price";
	public static final String PREF_CART_KEY_QUANTITY = "quantity";
	public static final String PREF_CART_KEY_PRICE_TOTAL = "price_total";
	public static final String PREF_CART_KEY_IMAGE = "image";
	public static final String PREF_CART_KEY_ID_DEFAULT_IMAGE = "id_default_image";




	public DBHandler(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db)
	{



		String PREF_CREATE_TABLE_ORDERS = "CREATE TABLE " + PREF_TABLE_ORDERS + "("
				+ PREF_CART_KEY_ID + "  INTEGER PRIMARY KEY   AUTOINCREMENT,"
				+ PREF_CART_KEY_NAME + " TEXT,"
				+ PREF_CART_KEY_DESCRIPTION + " TEXT,"
				+ PREF_CART_KEY_PRICE + " TEXT,"
				+ PREF_CART_KEY_QUANTITY + " INTEGER,"
				+ PREF_CART_KEY_PRICE_TOTAL + " DOUBLE NOT NULL,"
				+ PREF_CART_KEY_IMAGE + " TEXT,"
				+ PREF_CART_KEY_ID_DEFAULT_IMAGE + " TEXT"
				+ ")";



		db.execSQL(PREF_CREATE_TABLE_ORDERS);


	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed

				db.execSQL("DROP TABLE IF EXISTS " + PREF_TABLE_ORDERS);


				// Create tables again
				onCreate(db);
	}
}
