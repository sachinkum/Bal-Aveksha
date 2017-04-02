package com.example.admin.balaveksha;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChildNavbar extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_navbar);

        mToolbar =(Toolbar) findViewById(R.id.nav_actionbarhide);
        setSupportActionBar(mToolbar);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");


        navigationView=(NavigationView) findViewById(R.id.navigation_child);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;


                    case R.id.account:
                        Intent intent2  = new Intent(getApplicationContext(), Profile.class);
                        startActivity(intent2);


                        /**fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new AccountFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Account");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        **/

                        break;

                    case R.id.chatSession:

                        Intent intent1  = new Intent(getApplicationContext(), ChildSession.class);
                        startActivity(intent1);
                        /**fragmentTransaction=getSupportFragmentManager().beginTransaction();

                        fragmentTransaction.replace(R.id.main_container,new SessionFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Session");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                         **/
                        break;

                    case R.id.diagnosis:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new DiagnosisFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Diagnosis");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        break;

                    case R.id.about:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new AboutFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();


                        break;

                    case R.id.Faqs:
                        Intent transferto  = new Intent(getApplicationContext(), FAQstest.class);
                        startActivity(transferto);

                        break;
                    case R.id.logout:
                        Intent transferlogout  = new Intent(getApplicationContext(), LoginScreen.class);
                        startActivity(transferlogout);
                        break;

                }



                return true;
            }
        });


    }





    public void transferToChatSession(View view)
    {
        Intent intent  = new Intent(this, ChildSession.class);
        startActivity(intent);
    }

    public void transferToFAQs(View view)
    {
        Intent transferFAQs  = new Intent(this, FAQstest.class);
        startActivity(transferFAQs);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {

            return true;

        }
        return super.onOptionsItemSelected(item);
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

        Toast.makeText(ChildNavbar.this,"Please press Back again to exit",Toast.LENGTH_SHORT).show();


        //super.onBackPressed();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                twice=false;

            }
        },3000);
    }
}
