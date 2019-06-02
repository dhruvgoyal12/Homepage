package com.example.homepage;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
   /* private Button bt3 ;
    private Button bt2;
    private Button bt1;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Homefragmnet()).commit();

       /* bt3 = findViewById(R.id.bt3) ;
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
        getSupportActionBar().setTitle("Zine Homepage");*/



    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new Homefragmnet();
                            break;
                        case R.id.nav_reg:
                            selectedFragment = new RegistrationFragment();
                            break;
                        case R.id.nav_query:
                            selectedFragment = new QueryFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };
  /*  public void openWebsite(String url){
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
    }*/
}
