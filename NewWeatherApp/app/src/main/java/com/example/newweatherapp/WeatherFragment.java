package com.example.newweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONObject;

import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * The type Weather fragment.
 */
public class WeatherFragment extends Fragment {



    /**
     * The Text view city.
     */
    TextView TextViewCity;
    /**
     * The Text view updated.
     */
    TextView TextViewUpdated;
    /**
     * The Text view weather.
     */
    TextView TextViewWeather;
    /**
     * The Text view temperature.
     */
    TextView TextViewTemperature;
    /**
     * The Text view details.
     */
    TextView TextViewDetails;

    /**
     * The Handler.
     */
    Handler handler;

    /**
     * Instantiates a new Weather fragment.
     */
    public WeatherFragment() {
        handler = new Handler();
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_weatherfragment, container, false);
        TextViewCity = rootView.findViewById(R.id.TextViewCity);
        TextViewUpdated = rootView.findViewById(R.id.TextViewUpdated);
        TextViewWeather = rootView.findViewById(R.id.TextViewWeather);
        TextViewTemperature = rootView.findViewById(R.id.TextViewTemperature);
        TextViewDetails = rootView.findViewById(R.id.TextViewDetails);

        return rootView;
    }

    private void updateWeatherData(final String city) { // Creates a new thread for updateWeatherdata method.
        new Thread() {
            public void run() { // runs the JSON object
                final JSONObject JSON = CallJSON.Object(getActivity(),city);
                if (JSON == null) { // error checking to see if JSON is working if not display error message.
                    handler.post(new Runnable() {
                        public void run() {

                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.error),
                                    Toast.LENGTH_LONG).show();


                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            renderWeather(JSON); // Runs the JSON URL.

                        }
                    });
                }
            }
        }.start();
    }





    private void renderWeather(JSONObject JSON) { // Render Weather method.
        try {
            TextViewCity.setText(JSON.getString("name").toUpperCase(Locale.UK) + //  Formats the JSON to display correctly.
                    ", " + JSON.getJSONObject("sys").getString("county"));

            JSONObject Details = JSON.getJSONArray("weather").getJSONObject(0);
            JSONObject main = JSON.getJSONObject("main");
            TextViewDetails.setText(
                    Details.getString("description").toUpperCase(Locale.UK) + // Gets the humidity and pressure and displays with right format.
                            "\n" + "Humidity: " + main.getString("humidity") + "%" +
                            "\n" + "Pressure: " + main.getString("pressure") + " hPa");

            TextViewTemperature.setText(String.format("%.2f", main.getDouble("temp")) + " C"); // Gets the temperature using correct html url format.

            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            String updated = dateFormat.format(new Date(JSON.getLong("dt") * 1000)); // Gets the date and shows when it was last updated.
            TextViewUpdated.setText("Last Update " + updated);


        } catch (Exception e) {
            Log.e("PinPoint Weather", "Missing JSON Data!");
        }
    }

    /**
     * Change city.
     *
     * @param city the city
     */
    public void changeCity(String city){
        updateWeatherData(city);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateWeatherData(new City(getActivity()).getCity());

       // URI url = URI.parse("http://api.openweathermap.org/data/2.5/weather?q=plymouth,UK&APPID=7af53a7dd7d862e2fd639f6be9d0dc08");
        //Intent urlshow = new Intent(Intent.ACTION_VIEW,url);
        //startActivity(urlshow);

    }

}




