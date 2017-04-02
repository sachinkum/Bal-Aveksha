package com.example.admin.balaveksha;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antriksh on 29-03-2017.
 */

public class RegisterRequest extends StringRequest{


    private  static  final String REGISTER_REQUEST_URL= "http:///auth/register/";
    private Map<String,String>params;

    public RegisterRequest(String Fname, String Lname, String Email, String Username, String Password, Response.Listener<String>listener){

        super(Method.POST,REGISTER_REQUEST_URL,listener,null);

        params=new HashMap<>();
        params.put("first_name",Fname);
        params.put("last_name",Lname);
        params.put("email",Email);
        params.put("username",Username);
        params.put("password",Password);



    }



    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
