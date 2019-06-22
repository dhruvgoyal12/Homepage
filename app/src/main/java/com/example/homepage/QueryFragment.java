package com.example.homepage;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class QueryFragment extends Fragment {
    @Nullable
    private EditText collegeId, Name, Mobile, Query;
    private Button submit;
    private ProgressDialog progressDialog;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_query,container,false) ;

        collegeId = view.findViewById(R.id.et1);
        Name = view.findViewById(R.id.editText);
        Mobile = view.findViewById(R.id.editText4);
        Query = view.findViewById(R.id.editText5);
        submit = view.findViewById(R.id.button_query);
        progressDialog = new ProgressDialog(getActivity());

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                insert_query();
            }
        });
        return view;
    }

    private void insert_query(){
        String querylink = "https://android1234321.000webhostapp.com/connect/query.php";

        final String collegeid = collegeId.getText().toString().trim().toUpperCase();
        final String name_s = Name.getText().toString().trim();
        final String mobile_s = Mobile.getText().toString().trim();
        final String quer = Query.getText().toString().trim();

        if (name_s.equals("") || quer.equals("") || mobile_s.equals("") || collegeid.equals("")){
            Toast.makeText(getActivity(), "Please fill all the fields.",Toast.LENGTH_LONG).show();
        }

        else if (!(collegeid.length() == 11 || collegeid.length() == 12) ){
            Toast.makeText(getActivity().getApplicationContext(), "Invalid College ID",Toast.LENGTH_LONG).show();;
        }
        else if (!(collegeid.substring(0,7).equals("2019UCP") || collegeid.substring(0,7).equals("2019UCE") || collegeid.substring(0,7).equals("2019UCH") ||
                collegeid.substring(0,7).equals("2019UME") || collegeid.substring(0,7).equals("2019UMT") || collegeid.substring(0,7).equals("2019UEE") ||
                collegeid.substring(0,7).equals("2019UEC") || collegeid.substring(0,8).equals("2019KUCP") || collegeid.substring(0,8).equals("2019KUCE") || collegeid.substring(0,8).equals("2019KUCH") ||
                collegeid.substring(0,8).equals("2019KUME") || collegeid.substring(0,8).equals("2019KUMT") || collegeid.substring(0,8).equals("2019KUEE") ||
                collegeid.substring(0,8).equals("2019KUEC") ) ){
            Toast.makeText(getActivity().getApplicationContext(), "Invalid College ID",Toast.LENGTH_LONG).show();

        }
        else if (!(collegeid.substring(7).matches("[0-9]+") || collegeid.substring(8).matches("[0-9]+"))){
            Toast.makeText(getActivity().getApplicationContext(), "Invalid College ID",Toast.LENGTH_LONG).show();
        }



        else if (mobile_s.length() != 10){
            Toast.makeText(getActivity().getApplicationContext(), "Invalid Mobile Number",Toast.LENGTH_LONG).show();
        }

        else{

            progressDialog.setMessage("Sending Query...");
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, querylink ,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try{

                                JSONObject jsonObject = new JSONObject(response);

                                Toast.makeText(getActivity().getApplicationContext(), jsonObject.getString("message"),Toast.LENGTH_LONG).show();


                            }
                            catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Connection Problem, Try Again", Toast.LENGTH_LONG).show();

                        }
                    }){
                @Override
                protected Map<String, String> getParams(){
                    Map<String,String> params = new HashMap<>();
                    params.put("CollegeId", collegeid);
                    params.put("Name", name_s);
                    params.put("Mobile", mobile_s);
                    params.put("EmailId", quer);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
            requestQueue.add(stringRequest);

    }}
}
