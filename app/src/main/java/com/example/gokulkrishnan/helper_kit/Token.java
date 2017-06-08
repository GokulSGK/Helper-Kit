package com.example.gokulkrishnan.helper_kit;

import android.annotation.TargetApi;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Token extends AppCompatActivity {
    Button b11, b12;
    TextView t9, t10;
    Firebase f1, f2;
    String s, ss, g;
    Calendar cc;
    SimpleDateFormat df;
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);
        b11 = (Button) findViewById(R.id.button11);
        b12 = (Button) findViewById(R.id.button12);
        t10 = (TextView) findViewById(R.id.textView10);
        t9 = (TextView) findViewById(R.id.textView9);

        f1 = new Firebase("https://helper-kit.firebaseio.com/Token");
        f2 = new Firebase("https://helper-kit.firebaseio.com/Tokens");

        cc = Calendar.getInstance();
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        g = df.format(cc.getTime());


        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1.addValueEventListener(new ValueEventListener() {
                    @TargetApi(Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        s = dataSnapshot.getValue(String.class);
                        g = df.format(cc.getTime());
                        t9.setText(g);
                        t10.setText(s);


                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2.addValueEventListener(new ValueEventListener() {
                    @TargetApi(Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        ss = dataSnapshot.getValue(String.class);
                        g = df.format(cc.getTime());
                        t9.setText(g);
                        t10.setText(ss);


                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }

        });
    }
}
