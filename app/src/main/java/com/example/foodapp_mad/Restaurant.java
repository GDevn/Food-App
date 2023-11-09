package com.example.foodapp_mad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
//Holds all data relating to restaurant.
// A restaurant has a name and a list of foods that exist in that restaurant.
//The list of foods can be gathered from the food table and are extracted based on the attribute
//      'location' which denotes what restaurant the food originates from
public class Restaurant {
    public String name;
    private List<Food> Menu;
    private SQLiteDatabase db;

    public Restaurant(String resName){
        this.name = resName;
    }
    public void load(Context context, String table_name){
        this.db = new FoodDatabaseHelper(context.getApplicationContext()).getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + table_name + " WHERE food_location= " +
                        this.name, null);

        if(cursor.moveToFirst()){
            do{
                Menu.add(new Food(cursor.getInt(1),
                                  cursor.getString(2),
                                  cursor.getDouble(3),
                                  cursor.getString(4)));
            }while(cursor.moveToNext());

            cursor.close();
        }
    }



}
