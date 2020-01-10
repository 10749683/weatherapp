package com.example.newweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Register extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button register;

    EditText usernameSave;
    EditText emailSave;
    EditText passwordSave;
    EditText confirmpasswordSave;





    private static final String FILE_NAME = "data.txt";


    private void registerData() {

        username = (EditText) findViewById(R.id.editTextUsername);
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        confirmPassword = (EditText) findViewById(R.id.editTextPassword2);


        String password2 = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
        String confirmPassword2 = ((EditText) findViewById(R.id.editTextPassword2)).getText().toString();



        if (TextUtils.isEmpty(username.getText())){ // Error checking.
            username.setError("Missing Username!");
        } else
        if (TextUtils.isEmpty(email.getText())){
            email.setError("Missing Email!");
        } else
        if (TextUtils.isEmpty(password.getText())){
            password.setError("Missing Password!");

        } else
        if (!password2.equals(confirmPassword2)){
            confirmPassword.setError("Missing Password or Passwords do not match!");

        } else{
            registerUser();

        }

    }




    public void registerUser(){



        usernameSave = findViewById(R.id.editTextUsername);
        emailSave = findViewById(R.id.editTextEmail);
        passwordSave = findViewById(R.id.editTextPassword);
        confirmpasswordSave = findViewById(R.id.editTextPassword2);


        String username = ((EditText) findViewById(R.id.editTextUsername)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();


        FileOutputStream save = null;

        try {
            save = openFileOutput(FILE_NAME, MODE_PRIVATE);
            save.write(username.getBytes());
            save.write(email.getBytes());
            save.write(password.getBytes()); // Reference 05/01/2020 https://www.youtube.com/watch?v=EcfUkjlL9RI

            usernameSave.getText().clear();
            emailSave.getText().clear();
            passwordSave.getText().clear();
            confirmpasswordSave.getText().clear();

            Toast.makeText(this,"Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (save != null){
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
                Intent mapIntent = new Intent(Register.this,WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(Register.this,Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(Register.this,CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(Register.this,Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        register = (Button) findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registerData();
            }
        });
    }

}

// Reference: 05/01/2020 https://www.androidtutorialpoint.com/androidwithphp/login-and-registration-form-in-android/



