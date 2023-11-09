package com.example.foodapp_mad;

import java.util.ArrayList;

public class data_filter {
    // Filter Text i.e. 'Search by Restaurant'
    private String text;

    private static data_filter instance = null;
    private static ArrayList<data_filter> listOfFilters;

    public data_filter(String text) {
        this.text = text;
    }

    // Purpose: static 'get()' to obtain an instance that already has all the filters,
    //          instead of manually adding them somewhere else.
    public static ArrayList<data_filter> get() {
        if(instance == null) {
            listOfFilters = new ArrayList<data_filter>();
            listOfFilters.add(new data_filter("Search by Restaurant"));
            listOfFilters.add(new data_filter("Display All Food"));
        }
        return listOfFilters;
    }

    // Accessor
    public String getText() {
        return text;
    }
    // Mutator
    public void setText(String text) {
        this.text = text;
    }
}
