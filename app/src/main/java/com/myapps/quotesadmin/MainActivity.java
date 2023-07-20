package com.myapps.quotesadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.text.Format;

public class MainActivity extends AppCompatActivity {

    EditText newQuote;
    EditText serialNum;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newQuote = findViewById(R.id.EditTextQuote);
        enter = findViewById(R.id.enterBtn);
        serialNum = findViewById(R.id.serialNumEditTxt);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newquote = newQuote.getText().toString();
                String srNum = serialNum.getText().toString();

                Model model= new Model(newquote,srNum);
                /*model.setQuote(newquote);
                model.setNum(srNum);*/
                saveQuote(model);
            }
        });
    }

    private void saveQuote(Model model) {
        String srNum = serialNum.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference("QuoteList").child(srNum).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null){
                    Toast.makeText(MainActivity.this,"Quote added successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*.addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivity.this,"Quote added successfully", Toast.LENGTH_SHORT);
            }else {
                Toast.makeText(MainActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT);
            }
        }
    });*/

    /*static String timestampToString(Timestamp timestamp){
        return (DateFormat.format(
                "dd-MM-yyyy HH:mm:ss", timestamp.toDate()).toString());
    }*/
}