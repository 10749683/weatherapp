package com.example.newweatherapp;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * The type City.
 */
public class City {

    /**
     * The Preferences.
     */
    SharedPreferences preferences;

    /**
     * Instantiates a new City.
     *
     * @param activity the activity
     */
    public City(Activity activity) {
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    String getCity() {
        return preferences.getString("city", "Plymouth, UK");
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    void setCity(String city) {
        preferences.edit().putString("city", city).commit();
    }
}
