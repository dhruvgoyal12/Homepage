package com.example.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String[] NAMES={"Akash Sharma", "Bhanu" , "Brijraj" , "Charu" , "Dhruv Goyal" , "Harsh Chaudhary" ,"Kshitiz Kamal", "Muskan Garg"
    ,"Nikita Rautela" , "Pravesh Sandhu" , "Rajat Sharma" , "Saransh " , "Sneha Yadav" ,"Vaibhav"} ;
    String[] BRANCH={"CSE" , "ME" ,"ME" ,"CHE", "CSE" , "ME" , "CSE" , "CE" , "ME" , "CSE" , "EE" , "CHE" ,"EE" ,"CSE"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listview = findViewById(R.id.listview) ;
        getSupportActionBar().setTitle("Zine 2 year");

        CustomAdapter customAdapter = new CustomAdapter();

        listview.setAdapter(customAdapter);
    }
    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return NAMES.length;
        }
        @Override
        public Object getItem(int i){
            return null ;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i , View view , ViewGroup viewgroup){
            view = getLayoutInflater().inflate(R.layout.customlayout,null) ;

            TextView textView_name = view.findViewById(R.id.textView_name) ;
            TextView textView_branch = view.findViewById(R.id.textView_branch);
            textView_name.setText(NAMES[i]);
            textView_branch.setText(BRANCH[i]) ;
            return view ;
        }
    }


}
