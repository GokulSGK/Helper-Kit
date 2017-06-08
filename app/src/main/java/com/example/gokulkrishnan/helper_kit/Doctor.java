package com.example.gokulkrishnan.helper_kit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor extends AppCompatActivity {
    Button b15,b16,b17,b18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        final Context c = this;
        b15 = (Button)findViewById(R.id.button15);
        b16 = (Button)findViewById(R.id.button16);
        b17 = (Button)findViewById(R.id.button17);
        b18 = (Button)findViewById(R.id.button18);
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(c, Karthick.class);
                startActivity(i1);

            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(c, Sathish.class);
                startActivity(i2);

            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(c, Ishu.class);
                startActivity(i3);

            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(c, Sampledoc.class);
                startActivity(i4);

            }
        });
    }
}
