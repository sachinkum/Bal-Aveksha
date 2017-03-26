package com.example.admin.balaveksha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class CounsellerNavbar extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counseller_navbar);

        mToolbar = (Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");


        navigationView = (NavigationView) findViewById(R.id.navigation_child);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;


                    case R.id.account1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AccountFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Account");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();


                        break;

                    case R.id.chatSession1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new SessionFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Session");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;

                    case R.id.diagnosis1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new DiagnosisFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Diagnosis");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;

                    case R.id.about1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AboutFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();


                        break;

                    case R.id.logout1:
                        Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                        startActivity(intent);


                }


                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {

            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}