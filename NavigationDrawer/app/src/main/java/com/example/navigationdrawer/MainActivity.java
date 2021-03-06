package com.example.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.navigationdrawer.fragments.AlertsFragment;
import com.example.navigationdrawer.fragments.EmailFragment;
import com.example.navigationdrawer.fragments.InfoFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationDrawer);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (menuItem.getItemId()){

                    case R.id.option_alert:

                        fragment = new AlertsFragment();
                        fragmentTransaction = true;

                        break;

                    case R.id.option_email:

                        fragment = new EmailFragment();
                        fragmentTransaction = true;

                        break;

                    case R.id.option_info:

                        fragment = new InfoFragment();
                        fragmentTransaction = true;

                        break;

                    case R.id.menu_option_1:

                        Toast.makeText(MainActivity.this, "Clicked on item -> "+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                        break;


                }

                if(fragmentTransaction == true){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                    drawerLayout.closeDrawers();

                }




                return false;
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //open navigate menu
                drawerLayout.openDrawer(GravityCompat.START);
                return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
