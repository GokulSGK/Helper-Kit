package com.example.gokulkrishnan.helper_kit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Fees extends AppCompatActivity {
    Button b19,b20;
    EditText et1;
    Firebase ft1;
    String e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
        final Context c = this;
        et1 = (EditText)findViewById(R.id.editText17);
        b19 = (Button)findViewById(R.id.button19);
        b20 = (Button)findViewById(R.id.button20);
        ft1 = new Firebase("https://helper-kit.firebaseio.com/doctors/fees");
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        e = dataSnapshot.getValue(String.class);
                        et1.setText(e);

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
