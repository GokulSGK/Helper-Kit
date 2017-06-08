package com.example.gokulkrishnan.helper_kit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Order extends AppCompatActivity {
    EditText et1;
    Firebase ft1;
    String e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        et1 = (EditText)findViewById(R.id.editText18);
        ft1 = new Firebase("https://helper-kit.firebaseio.com/doctors/order1");
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
}
