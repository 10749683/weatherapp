package com.example.newweatherapp;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The type Call json.
 */
public class CallJSON {

    private static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?q=plymouth,UK&APPID=7af53a7dd7d862e2fd639f6be9d0dc08";

    /**
     * Object json object.
     *
     * @param context the context
     * @param city    the city
     * @return the json object
     *
     *
     *Creates the JSON object and creates a new URL for the JSON address.
     *
     * Creates a bufferedreader to get new Inputsteamreader which estiablishes the connection.
     *
     *
     *
     */
    public static JSONObject Object(Context context, String city) {
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("x-api-key", context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer JSON = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                JSON.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(JSON.toString());

            if (data.getInt("cod") != 200) {
                return null;
            }

            return data;


        } catch (Exception e) {
            return null;
        }
    }

}
