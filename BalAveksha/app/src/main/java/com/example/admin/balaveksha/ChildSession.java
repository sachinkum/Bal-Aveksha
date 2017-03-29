package com.example.admin.balaveksha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.transition.ActionBarTransition;
import android.support.v7.widget.Toolbar;

public class ChildSession extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_session);

        Toolbar mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("CHAT/SESSION");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
