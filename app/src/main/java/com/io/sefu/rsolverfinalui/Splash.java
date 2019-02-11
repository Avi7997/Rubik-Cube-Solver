package com.io.sefu.rsolverfinalui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //slide animation exists here

        setContentView(R.layout.activity_splash);

        //set the application orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intentStartWalkThrough = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentStartWalkThrough);
                    finish();
                }
            }
        };
        timer.start();
    }
}