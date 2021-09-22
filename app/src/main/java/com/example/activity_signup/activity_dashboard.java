package com.example.activity_signup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class activity_dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FragmentTransaction frag_transaction = getSupportFragmentManager().beginTransaction();
        frag_transaction.replace(R.id.nav_host_fragment, new fragment_home());
        frag_transaction.commit();

        bottomNavigation = findViewById(R.id.nav_view);
        bottomNavigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                FragmentTransaction frag_transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        frag_transaction.replace(R.id.nav_host_fragment, new fragment_home());
                        break;

                    case R.id.navigation_work:
                        frag_transaction.replace(R.id.nav_host_fragment, new fragment_workout());
                        break;

                    case R.id.navigation_calc:
                        frag_transaction.replace(R.id.nav_host_fragment, new fragment_calc());
                        break;

                    case R.id.navigation_walk:
                        frag_transaction.replace(R.id.nav_host_fragment, new fragment_steps());
                        break;

                    case R.id.navigation_rem:
                        frag_transaction.replace(R.id.nav_host_fragment, new fragment_profile());
                        break;
                }
                frag_transaction.commit();
            }
        });

    }
}