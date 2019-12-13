package com.anandshahdev.horoscopea;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView dobTV;
    private WebView msgWV;

    private String nameTXT;
    private String dobTXT;

    SharedPreferences shPf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        shPf = getSharedPreferences("login", MODE_PRIVATE);

        nameTV = findViewById(R.id.hi2);
        msgWV = findViewById(R.id.message);
        dobTV = findViewById(R.id.birthday);

        nameTXT = shPf.getString("name", "user");
        dobTXT = shPf.getString("dob", "0000");

        int dayMonth = Integer.parseInt(dobTXT);
        String dispMonth = retMon(dayMonth);
        String myZod = zodiac(dayMonth);


        nameTV.setText(nameTXT);
        dobTV.setText(dispMonth + " " +dayMonth%100 + "th");
        msgWV.setBackgroundColor(Color.TRANSPARENT);
        msgWV.loadUrl("https://anandshah.dev/" + myZod + ".html");
    }

    public static String retMon(int mm){
        mm = mm/100;

        String month = "";
        if (mm == 1)
            month = "January";
        else if (mm == 2)
            month = "February";
        else if (mm == 3)
            month = "March";
        else if (mm == 4)
            month = "April";
        else if (mm == 5)
            month = "May";
        else if (mm == 6)
            month = "June";
        else if (mm == 7)
            month = "July";
        else if (mm == 8)
            month = "August";
        else if (mm == 9)
            month = "September";
        else if (mm == 10)
            month = "October";
        else if (mm == 11)
            month = "November";
        else if (mm == 12)
            month = "December";

        return month;
    }

    public static String zodiac(int mm){
        int day = mm%100;
        mm = mm/100;

        String month = "";
        if (mm == 1)
            month = "January";
        else if (mm == 2)
            month = "February";
        else if (mm == 3)
            month = "March";
        else if (mm == 4)
            month = "April";
        else if (mm == 5)
            month = "May";
        else if (mm == 6)
            month = "June";
        else if (mm == 7)
            month = "July";
        else if (mm == 8)
            month = "August";
        else if (mm == 9)
            month = "September";
        else if (mm == 10)
            month = "October";
        else if (mm == 11)
            month = "November";
        else if (mm == 12)
            month = "December";



        String sign="";
        if (month == "January") {
            if (day < 20)
                sign = "Capricorn";
            else
                sign = "Aquarius";
        } else if (month == "February") {
            if (day < 19)
                sign = "Aquarius";
            else
                sign = "Pisces";
        } else if(month == "March") {
            if (day < 21)
                sign = "Pisces";
            else
                sign = "Aries";
        } else if (month == "April") {
            if (day < 20)
                sign = "Aries";
            else
                sign = "Taurus";
        } else if (month == "May") {
            if (day < 21)
                sign = "Taurus";
            else
                sign = "Gemini";
        } else if( month == "June") {
            if (day < 21)
                sign = "Gemini";
            else
                sign = "Cancer";
        } else if (month == "July") {
            if (day < 23)
                sign = "Cancer";
            else
                sign = "Leo";
        } else if( month == "August") {
            if (day < 23)
                sign = "Leo";
            else
                sign = "Virgo";
        } else if (month == "September") {
            if (day < 23)
                sign = "Virgo";
            else
                sign = "Libra";
        } else if (month == "October") {
            if (day < 23)
                sign = "Libra";
            else
                sign = "Scorpio";
        } else if (month == "November") {
            if (day < 22)
                sign = "Scorpio";
            else
                sign = "Sagittarius";
        } else if (month == "December") {
            if (day < 22)
                sign = "Sagittarius";
            else
                sign ="Capricorn";
        }
        return  sign;
    }
}
