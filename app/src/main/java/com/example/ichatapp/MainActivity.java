package com.example.ichatapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ichatapp.Fragment.Fragment_Group;
import com.example.ichatapp.Fragment.Fragment_Home;
import com.example.ichatapp.Fragment.Fragment_Message;
import com.example.ichatapp.Fragment.Fragment_Myaccount;
import com.example.ichatapp.Fragment.Fragment_Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bottomnavigation);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.mauchinh_dark));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        if (savedInstanceState == null){
            loadFragment(new Fragment_Home());
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.bottomHome:
                        fragment = new Fragment_Home();
                        loadFragment(fragment);
                        return true;

                    case R.id.bottomGroup:
                        fragment = new Fragment_Group();
                        loadFragment(fragment);
                        return true;

                    case R.id.bottomSearch:
                        fragment = new Fragment_Search();
                        loadFragment(fragment);
                        return true;

                    case R.id.bottomMess:
                        fragment = new Fragment_Message();
                        loadFragment(fragment);
                        return true;

                    case R.id.bottomProfile:
                        fragment = new Fragment_Myaccount();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayoutBottom, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}