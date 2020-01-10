package com.example.newweatherapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class CurrentWeather extends AppCompatActivity {




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Intent mapIntent = new Intent(CurrentWeather.this,WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(CurrentWeather.this,Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(CurrentWeather.this,CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(CurrentWeather.this,Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentweather);



        }


}


//  Reference:

//   10/01/2020 https://code.tutsplus.com/tutorials/create-a-weather-app-on-android--cms-21587

// Weather API:  https://openweathermap.org/appid




