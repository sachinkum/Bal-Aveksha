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

    public SaveRequest(String Username, String DOB, String Gender,String Age,String Address,String Adhar,String Contact,String Desc, Response.Listener<String>listener){

        super(Request.Method.POST,SAVE_REQUEST_URL,listener,null);

        params=new HashMap<>();
        params.put("username",Username);

        params.put("dateofbirth",DOB);
        params.put("gender",Gender);
        params.put("age",Age);
        params.put("address",Address);
        params.put("adhar",Adhar);
        params.put("contact",Contact);
        params.put("description",Desc);




    }



    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
