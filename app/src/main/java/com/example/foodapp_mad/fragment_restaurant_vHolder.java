package com.example.foodapp_mad;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class fragment_restaurant_vHolder extends RecyclerView.ViewHolder {
    ImageView logo;
    TextView name;

    public fragment_restaurant_vHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.restaurantLogo);
        name = itemView.findViewById(R.id.restaurantName);
    }
}
