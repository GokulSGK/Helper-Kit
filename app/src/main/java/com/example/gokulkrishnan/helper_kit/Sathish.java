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

public class Sathish extends AppCompatActivity {
    EditText et1;
    Firebase ft1;
    Button sa;
    String e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sathish);
        et1 = (EditText)findViewById(R.id.editText15);
        sa = (Button)findViewById(R.id.button24);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Sathish.this, "your Appoinment is fixed on 4.00Pm", Toast.LENGTH_SHORT).show();
            }
        });
        ft1 = new Firebase("https://helper-kit.firebaseio.com/doctors/sathish");
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
