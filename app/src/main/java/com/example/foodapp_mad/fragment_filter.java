package com.example.foodapp_mad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_filter extends Fragment {

    ArrayList<data_filter> data;

    public fragment_filter() {
        // Required empty public constructor
    }

    public fragment_filter(ArrayList<data_filter> data) {
        this.data = data;
    }

    // TODO: Rename and change types and number of parameters
    public static fragment_filter newInstance(String param1, String param2) {
        fragment_filter fragment = new fragment_filter();
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
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        RecyclerView rv = view.findViewById(R.id.filterRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        fragment_filter_adapter adapter = new fragment_filter_adapter(data);
        rv.setAdapter(adapter);
        return view;
    }
}