package com.example.foodapp_mad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


//This is where the initial values of the database should be inserted. This should only be run once

public class DBAdapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FoodApp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String FOOD_TABLE_NAME = "food_table";
    private static final String FOOD_ID = "food_id";
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_PRICE = "price";
    private static final String FOOD_LOCATION = "food_location";

    public static final String USER_TABLE_NAME = "user_table";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";

    public DBAdapter(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Check row count, if rows exist, return. If no rows exist, append data to database tables accordingly
        int rowCount = 0;



        String SQLquery = "INSERT INTO " + FOOD_TABLE_NAME + "( " +
                                         FOOD_NAME +", " +
                                         FOOD_PRICE + "," +
                                         FOOD_LOCATION + ") " +
                        "VALUES " + "( " + "Chicken, " + 15.6 + ", " + "KFC)," +
                                    "( " + "Zinger, " + 15.6 + ", " + "McDonalds), " +
                                    "( " + "Chips, " + 15.6 + ", " + "BurgerKing), " +
                                    "( " + "Beef, " + 15.6 + ", " + "Reds), " +
                                    "( " + "Pizza, " + 15.6 + ", " + "Dingus), " +
                                    "( " + "Cake, " + 15.6 + ", " + "Jumpy), " +
                                    "( " + "Fish, " + 15.6 + ", " + "Kings)";
        db.execSQL(SQLquery);

        


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
