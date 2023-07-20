package com.myapps.quotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    RecyclerView rcv;
    QuotesAdapter adapter;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.recyclerV);

        database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("QuoteList");
        list = new ArrayList<>();

        setRecyclerView();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Quotes quotes = dataSnapshot.getValue(Quotes.class);
                    list.add(quotes);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void setRecyclerView() {

       /* Collections.sort(list,Collections.reverseOrder());
        Collections.reverse(list);*/

        adapter= new QuotesAdapter(getApplicationContext(),list);
        rcv.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);

        adapter.notifyDataSetChanged();
    }
}