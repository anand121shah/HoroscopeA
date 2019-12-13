package com.anandshahdev.horoscopea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class FillActivity extends AppCompatActivity {

    private EditText name;
    private EditText dob;
    private Button submit;
    String nameVal;
    String dobVal;

    SharedPreferences shPf;
    SharedPreferences.Editor edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        submit = findViewById(R.id.submit_button);

        shPf = getSharedPreferences("login", MODE_PRIVATE);
        edt = shPf.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameVal = name.getText().toString();
                dobVal = dob.getText().toString();

                edt.putString("name", nameVal);
                edt.putString("dob", dobVal);

                edt.apply();

                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);


            }
        });
    }
}
