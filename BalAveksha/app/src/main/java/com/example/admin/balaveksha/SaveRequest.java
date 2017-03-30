package com.example.admin.balaveksha;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antriksh on 30-03-2017.
 */

public class SaveRequest extends StringRequest {

    private  static  final String SAVE_REQUEST_URL= "";
    private Map<String,String> params;

    public SaveRequest(String Fname, String Lname, String Email, String Username, String Password, String DOB, String Gender, Response.Listener<String>listener){

        super(Request.Method.POST,SAVE_REQUEST_URL,listener,null);

        params=new HashMap<>();
        params.put("fname",Fname);
        params.put("lname",Lname);
        params.put("email",Email);
        params.put("username",Username);
        params.put("password",Password);
        params.put("DateOfBirth",DOB);
        params.put("gender",Gender);



    }



    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
