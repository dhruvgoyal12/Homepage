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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private static final int REQUEST_CALL= 1 ;

    ImageButton ib1;
    ImageButton ib2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setTitle("Contact us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


           ib1 = findViewById(R.id.ib1);
           ib2 = findViewById(R.id.ib2);
           ib1.setOnClickListener(new View.OnClickListener(){

               @Override
               public void onClick(View v) {
                   phonecall("9812244847");
               }
           });

        ib2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                phonecall("9871856190");
            }
        });

      /*  listview.setOnClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] numberArray = {"7087488948","8619633583","8739912154","8619622895"};
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numberArray[position]));
                startActivity(intent);
            }
        });*/

      /*  imbt1= findViewById(R.id.imbt1) ;
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
        });*/
        getSupportActionBar().setTitle("Contact us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
   /* public void openfacebook(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse(url));
        startActivity(intent) ;

    }

    public void openinsta(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(Uri.parse(url));
        startActivity(intent) ;

    }*/


    private void phonecall(String number){
        //String number = "0000000000" ;

            String dial = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(dial)) ;
            startActivity(intent);
        }


    }


