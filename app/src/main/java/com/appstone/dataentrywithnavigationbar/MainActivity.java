package com.appstone.dataentrywithnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText metUsername;
    private EditText metPassword;
    private CheckBox mchkBox;


    private SharedPreferences prefManager;
    private SharedPreferences.Editor editor;

    public static String KEY_USERNAME = "USERNAME";
    public static String KEY_PASSWORD = "PASSWORD";
    public static String KEY_ISUSERlOGGEDIN = "ISUSERlOGGEDIN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metUsername = findViewById(R.id.et_username);
        metPassword = findViewById(R.id.et_password);
        mchkBox = findViewById(R.id.chkBox);

        prefManager = getSharedPreferences("APP_NAME", MODE_PRIVATE);
        editor = prefManager.edit();

        boolean isuserloggedin = prefManager.getBoolean("ISUSERlOGGEDIN", false);
        String username = prefManager.getString("KEY_USERNAME", "");
        String password = prefManager.getString("KEY_PASSWORD", "");

        metUsername.setText(username);
        metPassword.setText(password);
        if (isuserloggedin) {
            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
            finish();
        }
    }


    public void onClickedLogin(View view) {
        String Username = metUsername.getText().toString();
        String Password = metPassword.getText().toString();

        boolean Isrememberme = mchkBox.isChecked();
        editor.putString(KEY_USERNAME, Username);
        editor.putString(KEY_PASSWORD, Password);

        if (Isrememberme) {
            editor.putBoolean(KEY_ISUSERlOGGEDIN, true);
        }
        editor.apply();
        startActivity(new Intent(MainActivity.this, NavigationActivity.class));
        finish();
    }
}
