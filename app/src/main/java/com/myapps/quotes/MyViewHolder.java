package com.myapps.quotes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView quote;
    TextView num;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        quote = itemView.findViewById(R.id.quote);
        num = itemView.findViewById(R.id.number);
    }
}
