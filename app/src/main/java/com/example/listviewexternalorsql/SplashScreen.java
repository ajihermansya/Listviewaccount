package com.example.listviewexternalorsql;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(
                        new Intent(SplashScreen.this, Login.class)
                );
            }
        }, 3000);

        //splashscreen mengakses internet
        // melakukan pengecekan manifest / permission
        //
    }
}