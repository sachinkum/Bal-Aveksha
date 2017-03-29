package com.example.admin.balaveksha;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Toolbar mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("LOG IN");


    }

    public void transferToRegister(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

    public void transferToChild(View view) {

        Intent intent = new Intent(this, ChildNavbar.class);
        startActivity(intent);
        finish();

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
