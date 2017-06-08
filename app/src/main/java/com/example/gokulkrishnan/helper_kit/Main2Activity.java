package com.example.gokulkrishnan.helper_kit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2;
    Button b3;
    FirebaseAuth au;
    FirebaseAuth.AuthStateListener authlisten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = (EditText)findViewById(R.id.editText3);
        e2 = (EditText)findViewById(R.id.editText4);
        b3 = (Button)findViewById(R.id.button3);
        au = FirebaseAuth.getInstance();
        authlisten = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
              if(firebaseAuth.getCurrentUser() !=null){
                  Intent i = new Intent(Main2Activity.this, Patient.class);
                  startActivity(i);

              }
            }
        };
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startsign();;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        au.addAuthStateListener(authlisten);

    }

    public  void startsign()
    {
        String user = e1.getText().toString();
        String pass = e2.getText().toString();
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
        {
            Toast.makeText(Main2Activity.this, "please fill the forms", Toast.LENGTH_SHORT).show();
        }
        else
        {
            au.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(Main2Activity.this, "Signin Problem", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        }

}
