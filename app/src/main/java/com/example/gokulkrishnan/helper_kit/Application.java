package com.example.gokulkrishnan.helper_kit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Application extends AppCompatActivity {
    Button n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        final Context c = this;
        n2 = (Button)findViewById(R.id.n1);
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Application.this, "Application is Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
