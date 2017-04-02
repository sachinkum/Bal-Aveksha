package com.example.admin.balaveksha;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginScreen extends AppCompatActivity {


    private AutoCompleteTextView mUnameView;
    private AutoCompleteTextView mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login_screen);
        super.onCreate(savedInstanceState);

//        Toolbar mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
//        setSupportActionBar(mToolbar);

//        getSupportActionBar().setTitle("LOG IN");

        mUnameView = (AutoCompleteTextView) findViewById(R.id.editUName);
        mPasswordView = (AutoCompleteTextView) findViewById(R.id.editPassword);

        final Button bLogin=(Button) findViewById(R.id.bSignin);

      //  mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        // String email = mEmailView.getText().toString();

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



             //   Intent transfertochildFromlogin = new Intent(LoginScreen.this, ChildNavbar.class);
             //   LoginScreen.this.startActivity(transfertochildFromlogin);
             //   finish();


                final String Uname = mUnameView.getText().toString();
                final String Password = mPasswordView.getText().toString();


                Response.Listener<String>responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {




                        try{

                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success=jsonResponse.getBoolean("success");

                            if(success){

                                Intent transfertochildFromlogin = new Intent(LoginScreen.this, ChildNavbar.class);
                                LoginScreen.this.startActivity(transfertochildFromlogin);
                                finish();

                            }

                            else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginScreen.this);

                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();


                            }

                        }catch (JSONException e){

                            e.printStackTrace();

                        }

                    }
                };





           LoginRequest loginRequest=new LoginRequest(Uname,Password,responseListener);

                RequestQueue queue = Volley.newRequestQueue(LoginScreen.this);

                queue.add(loginRequest);



            }
        });



    }

    public void transferToRegister(View view) {

        Intent transferToregister = new Intent(this, RegisterActivity.class);
        startActivity(transferToregister);

    }


    boolean twice=false;

    @Override
    public void onBackPressed() {

        if(twice==true){

            Intent intent=new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);


        }

        twice=true;

        Toast.makeText(LoginScreen.this,"Please press Back again to exit",Toast.LENGTH_SHORT).show();


        //super.onBackPressed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                twice=false;

            }
        },3000);
    }

}
