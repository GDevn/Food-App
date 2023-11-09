package com.example.foodapp_mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.content.Context;
import android.database.sqlite.*;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<data_filter> filter_array;
    ArrayList<data_restaurant> restaurant_array;

    public MainActivity() {
        filter_array = data_filter.get();

        // Temporarily hold restaurant data
        restaurant_array = new ArrayList<data_restaurant>();
        restaurant_array.add(new data_restaurant("Hell's Kitchen"));
        restaurant_array.add(new data_restaurant("McDonalds"));
        restaurant_array.add(new data_restaurant("Hungry Jacks"));
        restaurant_array.add(new data_restaurant("Nandos"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = null;
        Restaurant KFC = new Restaurant("KFC");
        KFC.load(context, "food_table");

        SQLiteDatabase myDB = openOrCreateDatabase("FoodStore", MODE_PRIVATE, null);
        myDB.beginTransaction();

        // Fragment Part
        FragmentManager frag = getSupportFragmentManager();

        fragment_filter f_filter = (fragment_filter) frag.findFragmentById(R.id.filter_FL);
        if(f_filter == null) {
            f_filter = new fragment_filter(filter_array);
            frag.beginTransaction().add(R.id.filter_FL, f_filter).commit();
        }

        fragment_restaurant f_restaurant = (fragment_restaurant) frag.findFragmentById(R.id.fragment_main_FL);
        if(f_restaurant == null) {
            f_restaurant = new fragment_restaurant(restaurant_array);
            frag.beginTransaction().add(R.id.fragment_main_FL, f_restaurant).commit();
        }
    }
}