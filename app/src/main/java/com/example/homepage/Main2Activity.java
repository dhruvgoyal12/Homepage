package com.example.homepage;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,
            R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene,R.drawable.photo_scene

    };
    String[] NAMES={"Akash Sharma", "Bhanu " , "Brijraj" , "Charu" , "Dhruv Goyal" , "Harsh Chaudhary" ,"Kshitiz Kamal", "Muskan Garg"
    ,"Nikita Rautela" , "Pravesh Sandhu" , "Rajat Agarwal" , "Saransh Tayal"
             , "Sneha Yadav" ,"Vaibhav Agarwal"} ;
    String[] BRANCH={"CSE" , "ME" ,"ME" ,"CHE", "CSE" , "ME" , "CSE" , "CE" , "ME" , "CSE" , "EE" , "CHE" ,"EE" ,"CSE"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listview = findViewById(R.id.listview) ;
        getSupportActionBar().setTitle("Zine 2 year");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

            ImageView imageView = view.findViewById(R.id.iv);
            TextView textView_name = view.findViewById(R.id.textView_name) ;
            TextView textView_branch = view.findViewById(R.id.textView_branch);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_branch.setText(BRANCH[i]) ;
            return view ;
        }
    }


}
