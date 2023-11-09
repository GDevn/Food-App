package com.example.foodapp_mad;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class fragment_filter_vHolder extends RecyclerView.ViewHolder {
    Button button;

    public fragment_filter_vHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.filter_button);
    }
}
