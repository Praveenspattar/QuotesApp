package com.myapps.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<MyViewHolder>{

    Context context;
    List<Quotes> list;

    public QuotesAdapter(Context context, List<Quotes> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Collections.reverse(list);
        Quotes quotes = list.get(position);
        holder.quote.setText(quotes.getQuote());
        holder.num.setText(quotes.getNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
