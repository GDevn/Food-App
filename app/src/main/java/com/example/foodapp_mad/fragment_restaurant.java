package com.example.foodapp_mad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_restaurant#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_restaurant extends Fragment {

    ArrayList<data_restaurant> data;

    public fragment_restaurant() {
        // Required empty public constructor
    }

    public fragment_restaurant(ArrayList<data_restaurant> data) {
        this.data = data;
    }

    // TODO: Rename and change types and number of parameters
    public static fragment_restaurant newInstance(String param1, String param2) {
        fragment_restaurant fragment = new fragment_restaurant();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        RecyclerView rv = view.findViewById(R.id.restaurantRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        fragment_restaurant_adapter adapter = new fragment_restaurant_adapter(data);
        rv.setAdapter(adapter);
        return view;
    }
}