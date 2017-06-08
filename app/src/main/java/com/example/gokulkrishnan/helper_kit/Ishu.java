package com.example.gokulkrishnan.helper_kit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Ishu extends AppCompatActivity {
    EditText et1;
    Firebase ft1;
    Button ice;
    String e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishu);
        et1 = (EditText)findViewById(R.id.editText13);
        ice = (Button)findViewById(R.id.button26);
        ice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ishu.this, "Your appointment is fixed on 10.00Am", Toast.LENGTH_SHORT).show();
            }
        });
        ft1 = new Firebase("https://helper-kit.firebaseio.com/doctors/ishu");
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
