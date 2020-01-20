package com.example.newweatherapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The type Splash.
 *
 * Uses an intent to display the splashscreen.
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent splash = new Intent(this, WeatherApp.class);
        startActivity(splash);

    }
}
