package com.example.foodapp_mad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment_restaurant_adapter extends RecyclerView.Adapter<fragment_restaurant_vHolder>{
    ArrayList<data_restaurant> data;

    public fragment_restaurant_adapter(ArrayList<data_restaurant> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public fragment_restaurant_vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_restaurant_selection,parent,false);
        fragment_restaurant_vHolder myViewHolder = new fragment_restaurant_vHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull fragment_restaurant_vHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
