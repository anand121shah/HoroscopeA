package com.anandshahdev.horoscopea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private String nameTXT;
    private String dobTXT;

    SharedPreferences shPf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        shPf = getSharedPreferences("login", MODE_PRIVATE);

        nameTXT = shPf.getString("name", "user");
        dobTXT = shPf.getString("dob", "0000");

        if (nameTXT == "user" && dobTXT == "0000"){
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(getApplicationContext(),
                    DashboardActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
