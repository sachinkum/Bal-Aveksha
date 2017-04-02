package com.example.admin.balaveksha;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antriksh on 30-03-2017.
 */

public class LoginRequest extends StringRequest {
    private  static  final String LOGIN_REQUEST_URL= "Domain name/auth/login/";
    private Map<String,String> params;

    public LoginRequest(String Username, String Password, Response.Listener<String>listener){

        super(Method.POST,LOGIN_REQUEST_URL,listener,null);

        params=new HashMap<>();

        params.put("username",Username);
        params.put("password",Password);



    }



    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
