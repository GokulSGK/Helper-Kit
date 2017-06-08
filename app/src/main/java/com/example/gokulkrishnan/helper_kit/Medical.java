package com.example.gokulkrishnan.helper_kit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Medical extends AppCompatActivity {
    Button b21,b22;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        final Context c = this;
        b21 = (Button)findViewById(R.id.button21);
        b22 = (Button)findViewById(R.id.button22);
        im = (ImageView)findViewById(R.id.imageView6);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(c, Order.class);
                startActivity(t);


            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(c, Order.class);
                startActivity(t);


            }
        });
    }
}
