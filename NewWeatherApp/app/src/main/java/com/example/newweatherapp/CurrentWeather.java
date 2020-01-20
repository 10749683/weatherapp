package com.example.newweatherapp;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


/**
 * The type Current weather.
 */
public class CurrentWeather extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                Intent mapIntent = new Intent(CurrentWeather.this, WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(CurrentWeather.this, Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(CurrentWeather.this, CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(CurrentWeather.this, Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                showInputDialog();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void showInputDialog(){
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setTitle("Change city");
        final EditText userInput = new EditText(this);
        userInput.setInputType(InputType.TYPE_CLASS_TEXT);
        Builder.setView(userInput);
        Builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(userInput.getText().toString());
            }
        });
        Builder.show();
    }

    /**
     * Change city.
     *
     * @param city the city
     *
     * 
     *
     */
    public void changeCity(String city){
        WeatherFragment weatherfragment = (WeatherFragment)getSupportFragmentManager().findFragmentById(R.id.currentweather);
        weatherfragment.changeCity(city);
        new City(this).setCity(city);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentweather); // Links the xml page with the java page.

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.currentweather, new WeatherFragment())
                    .commit();
        }
    }


}


//  Reference:

//   10/01/2020 https://code.tutsplus.com/tutorials/create-a-weather-app-on-android--cms-21587
//  16/01/2020 https://www.survivingwithandroid.com/android-openweathermap-app-weather-app/

// Weather API:  https://openweathermap.org/appid

// http://api.openweathermap.org/data/2.5/weather?q=city,country&APPID=7af53a7dd7d862e2fd639f6be9d0dc08



