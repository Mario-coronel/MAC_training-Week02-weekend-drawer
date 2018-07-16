package com.example.admin.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.admin.myapplication.activity1.AsyncTasks;
import com.example.admin.myapplication.activity2.EMI;
import com.example.admin.myapplication.activity3.Calculator;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                onActivityManage(menuItem);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.overflow_menu, menu);
        return true;
    }

    public void onActivityManage(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.activity1:
                item.setChecked(true);
                displayMessage("Activity 1 selected");
                System.out.println("Start Intent");
                intent = new Intent(this, AsyncTasks.class);
                startActivity(intent);
                break;
            case R.id.activity2:
                item.setChecked(true);
                displayMessage("Activity 2 selected");
                intent = new Intent(this, EMI.class);
                startActivity(intent);
                break;
            case R.id.activity3:
                item.setChecked(true);
                displayMessage("Activity 3 selected");
                intent = new Intent(this, Calculator.class);
                startActivity(intent);
                break;

        }


    }

}

