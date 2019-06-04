package com.example.homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.logging.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        android.os.Handler handler1= new android.os.Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },1000);



    }
    @Override
    public void onBackPressed(){
        System.exit(0);
    }
}
