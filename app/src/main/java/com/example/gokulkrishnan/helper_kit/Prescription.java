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

public class Prescription extends AppCompatActivity {
    Button b13,b14;
    Firebase f3,f4;
    String s,ss;
    EditText e11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        f3 = new Firebase("https://helper-kit.firebaseio.com/description/pres");
        f4 = new Firebase("https://helper-kit.firebaseio.com/description/new");
        b13 = (Button)findViewById(R.id.button13);
        b14 = (Button)findViewById(R.id.button14);
        e11 = (EditText)findViewById(R.id.editText11);
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        s = dataSnapshot.getValue(String.class);
                        e11.setText(s);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ss = dataSnapshot.getValue(String.class);
                        e11.setText(ss);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });

    }
}
