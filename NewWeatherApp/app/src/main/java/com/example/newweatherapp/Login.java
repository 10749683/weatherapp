package com.example.newweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button register;

    EditText usernameSave;
    EditText emailSave;
    EditText passwordSave;
    EditText confirmpasswordSave;

    private Button registerButton;
    private static final String FILE_NAME = "data.txt";



    public void login(){

        usernameSave = findViewById(R.id.editTextUsername);
        emailSave = findViewById(R.id.editTextEmail);
        passwordSave = findViewById(R.id.editTextPassword);
        confirmpasswordSave = findViewById(R.id.editTextPassword2);

        String username = ((EditText) findViewById(R.id.editTextUsername)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
        String confirmPassword = ((EditText) findViewById(R.id.editTextPassword2)).getText().toString();

        FileInputStream save = null;

        try {
            save = openFileInput(FILE_NAME);
            InputStreamReader Input = new InputStreamReader(save);
            BufferedReader Reader = new BufferedReader(Input);
            StringBuilder Builder = new StringBuilder();
            String text;

            while ((text = Reader.readLine()) != null ){
                Builder.append(text).append("\n");
            }

            usernameSave.setText(Builder.toString());
            emailSave.setText(Builder.toString());
            passwordSave.setText(Builder.toString());
            confirmpasswordSave.setText(Builder.toString());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(save != null){
                try {
                    save.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


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
                Intent mapIntent = new Intent(Login.this,WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(Login.this,Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(Login.this,CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(Login.this,Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this,Register.class);
                startActivity(registerIntent);
            }
        });
    }

}



