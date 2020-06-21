package com.appstone.dataentrywithnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout nDrawerLayout;
    private SharedPreferences prefManager;
    private SharedPreferences.Editor editor;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar nToolBar = findViewById(R.id.tl_navigation);
        setSupportActionBar(nToolBar);

        nDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView nNavigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, nDrawerLayout, nToolBar, R.string.open, R.string.close);
        drawerToggle.syncState();

        nNavigationView.setNavigationItemSelectedListener(this);

        prefManager = getSharedPreferences("APP_NAME", MODE_PRIVATE);
        editor = prefManager.edit();

        databaseHelper = new DatabaseHelper(NavigationActivity.this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        nDrawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.menu_logout:
                editor.putBoolean(MainActivity.KEY_ISUSERlOGGEDIN, false);
                editor.putString(MainActivity.KEY_PASSWORD, "");
                editor.putString(MainActivity.KEY_USERNAME, "");
                editor.apply();
                startActivity(new Intent(NavigationActivity.this, MainActivity.class));

                break;
            case R.id.menu_sendData:
                startActivity(new Intent(NavigationActivity.this, SendData.class));

                break;
            case R.id.menu_view:

                startActivity(new Intent(NavigationActivity.this,StudentDataView.class));
                break;
        }

        return false;
    }
}
