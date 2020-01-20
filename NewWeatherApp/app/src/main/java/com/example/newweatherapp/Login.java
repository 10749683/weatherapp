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

/**
 * The type Login.
 */
public class Login extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button register;

    /**
     * The Username save.
     */
    EditText usernameSave;
    /**
     * The Password save.
     */
// EditText emailSave;
    EditText passwordSave;
    // EditText confirmpasswordSave;

    private Button registerButton;
    private Button loginButton;
    private static final String FILE_NAME = "data.txt";


    /**
     * Login.
     */
    public void login() {

        usernameSave = findViewById(R.id.editTextUsernameLogin); // Linking the edittext "usernameSave" with the edittext in the xml file using the id.
        //emailSave = findViewById(R.id.editTextEmail);  // Same as the username however is no longer required as the login pages only requires username and password.
        passwordSave = findViewById(R.id.editTextPasswordLogin); // Linking the edittext like the username but with "passwordSave" instead.
        // confirmpasswordSave = findViewById(R.id.editTextPassword2); // Is nolonger required is only needed for the register page.


        if (TextUtils.isEmpty(usernameSave.getText())) { // Error checking making sure the username field has a value.
            usernameSave.setError("Missing Username!"); // Sets an error to display if no field is entered.
        } else if (TextUtils.isEmpty(passwordSave.getText())) { // Same as username but checking the password field
            passwordSave.setError("Missing Password!"); // Sets an error to display if no field is entered.
        }

        Toast.makeText(this, "User logged in!", Toast.LENGTH_SHORT).show(); // Toast is being used to display text to the user showing they have logged in
        // Currently the login page doesent work as the register data isn't in a database
        // Therefore this is just showing what will happen when a user actually logs in.

        // This below doesen't work below but is trying to read the written file from register.

        /*

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

*/
    }

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
                Intent mapIntent = new Intent(Login.this, WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(Login.this, Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(Login.this, CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(Login.this, Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();

            }
        });

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
            }
        });
    }

}



