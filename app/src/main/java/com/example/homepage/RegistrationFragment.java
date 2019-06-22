package com.example.homepage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistrationFragment extends Fragment {
    @Nullable
    // Creating edittexts
    private EditText collegeId, name, emailId, mobile;
    // Creating Spinners
    private Spinner branch, hosteler;
    // Creating button
    private Button btregister;
    // Creating progress dialog
     private ProgressDialog progressDialog ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration,container,false) ;
       // Assigning ids
        collegeId = view.findViewById(R.id.et1);
        name = view.findViewById(R.id.editText);
        emailId = view.findViewById(R.id.et3);
        mobile = view.findViewById(R.id.editText4);
        branch = view.findViewById(R.id.spinner2);
        hosteler = view.findViewById(R.id.spinner1);
        btregister = view.findViewById(R.id.button);
        progressDialog = new ProgressDialog(getActivity());

        // Action to perform on click
        btregister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


        return view;

    }

    private void registerUser(){
        String http = "https://android1234321.000webhostapp.com/connect/file.php";
        final String collegeid = collegeId.getText().toString().trim().toUpperCase();
        final String name_s = name.getText().toString().trim();
        final String mobile_s = mobile.getText().toString().trim();
        final String email = emailId.getText().toString().trim();
        final String bran = branch.getSelectedItem().toString().trim();
        final String hostel = hosteler.getSelectedItem().toString().trim();

        if (name_s.equals("") || email.equals("") || mobile_s.equals("") || collegeid.equals("")){
            Toast.makeText(getActivity(), "Please fill all the fields.",Toast.LENGTH_LONG).show();
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(email).matches() == false) {
            Toast.makeText(getActivity(), "Email Address is of Invalid Format", Toast.LENGTH_LONG).show();

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

       progressDialog.setMessage("Registering user...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, http ,
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
                new ErrorListener() {
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
                params.put("EmailId", email);
                params.put("Branch", bran);
                params.put("Hosteler", hostel);
                return params;
            }
        };
       RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
       requestQueue.add(stringRequest);
    }}
}
