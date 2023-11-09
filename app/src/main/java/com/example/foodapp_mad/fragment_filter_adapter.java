package com.example.foodapp_mad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment_filter_adapter extends RecyclerView.Adapter<fragment_filter_vHolder>{
    ArrayList<data_filter> data;

    public fragment_filter_adapter(ArrayList<data_filter> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public fragment_filter_vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_filter_selection,parent,false);
        fragment_filter_vHolder myViewHolder = new fragment_filter_vHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull fragment_filter_vHolder holder, int position) {
        holder.button.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
