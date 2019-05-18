package com.example.homepage;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button bt3 ;
    private Button bt2;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt3 = findViewById(R.id.bt3) ;
        bt2 = findViewById(R.id.bt2) ;
        bt1 = findViewById(R.id.bt1) ;
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openWebsite("http://zine.co.in");
            }
        });
        bt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openActivity3();
            }
        } );
        getSupportActionBar().setTitle("Zine Homepage");

    }
    public void openWebsite(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url)) ;

        startActivity(intent) ;

    }
    public void openActivity2(){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class) ;
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(MainActivity.this,Main3Activity.class) ;
        startActivity(intent) ;
    }
}
