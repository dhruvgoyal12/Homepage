package com.example.homepage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private ImageButton imbt1;
    private ImageButton imbt2;
    private static final int REQUEST_CALL= 1 ;
    private ImageButton imbt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imbt1= findViewById(R.id.imbt1) ;
        imbt2=findViewById(R.id.imbt2);
        imbt3=findViewById(R.id.imbt3) ;
        imbt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openfacebook("https://www.facebook.com/ROBOTICS.ZINE/");
            }


        });
        imbt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openinsta("https://www.instagram.com/zine.robotics/") ;
            }
        });
        imbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonecall();
            }
        });
        getSupportActionBar().setTitle("Contact us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void openfacebook(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse(url));
        startActivity(intent) ;

    }

    public void openinsta(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse(url));
        startActivity(intent) ;

    }
    private void phonecall(){
        String number = "0000000000" ;
        if (ContextCompat.checkSelfPermission(Main3Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main3Activity.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);

        }
        else{
            String dial = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(dial)) ;
            startActivity(intent);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                phonecall();
            }
            else
            {
                Toast.makeText(this, "Permission Denied" ,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
