package com.sp.watchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    ExploreFragment explorefragment;
    NewListingFragment newlistingfragment;
    UserProfileFragment userprofilefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explorefragment = new ExploreFragment();
        newlistingfragment = new NewListingFragment();
        userprofilefragment = new UserProfileFragment();

        navigationView = findViewById(R. id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new ExploreFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_explore);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_explore:
                        fragment = explorefragment;
                        break;
                    case R.id.nav_newlisting:
                        fragment = newlistingfragment;
                        break;
                    case R.id.nav_userprofile:
                        fragment = userprofilefragment;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                return true;
            }
        });
    }
}