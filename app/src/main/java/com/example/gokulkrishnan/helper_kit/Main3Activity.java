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

public class Main3Activity extends AppCompatActivity {
    EditText e3,e4;
    Button b4;
    FirebaseAuth authe;
    FirebaseAuth.AuthStateListener authlistene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        e3 = (EditText)findViewById(R.id.editText);
        e4 = (EditText)findViewById(R.id.editText2);
        b4 = (Button)findViewById(R.id.button4);
        authe = FirebaseAuth.getInstance();
        authlistene = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() !=null){
                    Intent i = new Intent(Main3Activity.this, Medical.class);
                    startActivity(i);

                }
            }
        };
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startsign();;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        authe.addAuthStateListener(authlistene);

    }

    public  void startsign()
    {
        String user = e3.getText().toString();
        String pass = e4.getText().toString();
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
        {
            Toast.makeText(Main3Activity.this, "please fill the forms", Toast.LENGTH_SHORT).show();
        }
        else
        {
            authe.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(Main3Activity.this, "Signin Problem", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
}
