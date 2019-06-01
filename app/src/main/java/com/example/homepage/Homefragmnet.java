package com.example.homepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Homefragmnet extends Fragment {
    @Nullable

    private Button bt3 ;
    private Button bt2;
    private Button bt1;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        bt3 = view.findViewById(R.id.bt3) ;
        bt2 = view.findViewById(R.id.bt2) ;
        bt1 = view.findViewById(R.id.bt1) ;

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openWebsite("http://zine.co.in");
            }
        });

        bt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openActivity3();
            }
        } );
        return view;
    }
        public void openWebsite(String url){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url)) ;

            startActivity(intent) ;

        }
        public void openActivity2(){
            Intent intent = new Intent(getActivity(),Main2Activity.class) ;
            startActivity(intent);
        }
        public void openActivity3(){
            Intent intent = new Intent(getActivity(),Main3Activity.class) ;
            startActivity(intent) ;
        }
}

