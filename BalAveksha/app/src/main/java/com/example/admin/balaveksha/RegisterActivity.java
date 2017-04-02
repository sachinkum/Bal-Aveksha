package com.example.admin.balaveksha;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private AutoCompleteTextView mFnameView;
    private AutoCompleteTextView mLnameView;
    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mUnameView;
    private AutoCompleteTextView mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("Child Register");


       // final EditText etFname=(EditText) findViewById(R.id.editFName);
       // final EditText etLname=(EditText) findViewById(R.id.editLName);
        //final EditText etEmail=(EditText) findViewById(R.id.email);
       // final EditText etUname=(EditText) findViewById(R.id.editUName);
       // final EditText etPassword=(EditText) findViewById(R.id.password);

        final Button bRegister=(Button) findViewById(R.id.register);


        mFnameView = (AutoCompleteTextView) findViewById(R.id.editFName);
        mLnameView = (AutoCompleteTextView) findViewById(R.id.editLName);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.editEmail);
        mUnameView = (AutoCompleteTextView) findViewById(R.id.editUName);
        mPasswordView = (AutoCompleteTextView) findViewById(R.id.editPassword);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Fname = mFnameView.getText().toString();

                final String Lname = mLnameView.getText().toString();
                final String Email = mEmailView.getText().toString();
                final String Uname = mUnameView.getText().toString();
                final String Password = mPasswordView.getText().toString();




             //   Intent transferToProfile = new Intent(RegisterActivity.this,Profile.class);

               // transferToProfile.putExtra("username",Uname);

              //  RegisterActivity.this.startActivity(transferToProfile);
              //  finish();





                Response.Listener<String>responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success=jsonResponse.getBoolean("success");

                            if(success){

                                String Firstname=jsonResponse.getString("fname");
                                String Lastname=jsonResponse.getString("lname");
                                String Emailid=jsonResponse.getString("email");
                                String Username=jsonResponse.getString("username");
                                String Password=jsonResponse.getString("password");


                                Intent transferToProfile = new Intent(RegisterActivity.this,Profile.class);

                                transferToProfile.putExtra("fname",Firstname);
                                transferToProfile.putExtra("lname",Lastname);
                                transferToProfile.putExtra("email",Emailid);
                                transferToProfile.putExtra("username",Username);
                                transferToProfile.putExtra("password",Password);


                                RegisterActivity.this.startActivity(transferToProfile);
                                finish();


                            }

                            else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);

                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();


                            }

                        }catch (JSONException e){

                            e.printStackTrace();

                        }

                    }
                };




                RegisterRequest registerRequest=new RegisterRequest(Fname,Lname,Email,Uname,Password,responseListener);

                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);

                queue.add(registerRequest);



            }
        });






/**        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.problem_arrays, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


**/

    }


/**

    public void radioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioMale:
                if (checked) {
                    Toast.makeText(getApplicationContext(), " Male", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.radioFemale:
                if (checked) {
                    Toast.makeText(getApplicationContext(), " Female", Toast.LENGTH_SHORT).show();
                    break;
                }

        }


    }

**/



}
