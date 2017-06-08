package com.example.gokulkrishnan.helper_kit;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Gokul Krishnan on 13-05-2017.
 */
public class Fireapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
