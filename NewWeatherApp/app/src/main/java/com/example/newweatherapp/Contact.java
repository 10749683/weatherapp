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

public class Contact extends AppCompatActivity {

    private Button contactButton; // Creating the button variable kept it private so it can only be accessed here.
    private EditText issue; // Creating the issue which is using the edittext in the xml variable kept it private so it can only be accessed here.
    private EditText description; // Creating the description which is using the edittext in the xml variable kept it private so it can only be accessed here.
    private EditText email; // Creating the email which is using the edittext in the xml variable kept it private so it can only be accessed here.

    private void Contact() { // Contact method.

        issue = findViewById(R.id.editTextIssue); // linking the issue with the edittext in xml
        description = findViewById(R.id.editTextDescription); // linking the description with the edittext in xml
        email = findViewById(R.id.editTextEmail); // linking the email with the edittext in xml

        if (TextUtils.isEmpty(issue.getText())){ // if and else statements for error checking getting the text.
            issue.setError("Missing issue!"); // displays a message when text is missing in the field.
        } else
        if(TextUtils.isEmpty(description.getText())){ // using TextUtils to check if the filed is empty and gets the text.
            description.setError("Missing Description!"); // same as before displaying a message when the field is missing.
        }else
        if(TextUtils.isEmpty(email.getText())){ // using TextUtils to check if the filed is empty and gets the text.
            email.setError("Missing Email!"); // same as before displaying a message when the field is missing.
        }else{

            sendContact(); // Runs the sendContact method.

        }



    }

    private void sendContact(){

        String issue = ((EditText)findViewById(R.id.editTextIssue)).getText().toString(); // changing the issue to a string.
        String description = ((EditText)findViewById(R.id.editTextDescription)).getText().toString(); // changing the description to a string.
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString(); // changing the email to a string.

        Intent contact = new Intent(Intent.ACTION_SEND); // uses intent to open an email client.

        contact.putExtra(Intent.EXTRA_EMAIL,new String[]{"10749683@cityplym.ac.uk"}); // setups the email client to send the email to that address.
        contact.putExtra(Intent.EXTRA_SUBJECT,"Contact Us - Issue: "+issue); // Puts the issue in the heading
        contact.putExtra(Intent.EXTRA_TEXT,"Description:" +description + "\n\nCustomer's Email: " +email); // Puts the description in the text field in the email.
        contact.setType("message/rfc822"); // converts the message to email format

        try { // try and catch for sending the email.
            startActivity(Intent.createChooser(contact, "Send Email: "));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(Contact.this, "Unable to send Email.",Toast.LENGTH_SHORT).show(); // Sends an error message if email cant been sent.
        }
        finish(); // finishes the method
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Creates the menu overlay.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu); // references the menu.xml
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Intent mapIntent = new Intent(Contact.this,WeatherApp.class); // creates the intent for the first button on the menu
                startActivity(mapIntent); // starts mapIntent when button is pressed which changes page.
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(Contact.this,Login.class); // same as before but creating it for the login page instead of weatherapp class.
                startActivity(loginIntent); // starts loginIntent which changes to the login page.
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent weatherIntent = new Intent(Contact.this,CurrentWeather.class); // same as before but creating it for the Current WEather class.
                startActivity(weatherIntent); // starts weatherIntent which changes to the CurrentWeather page.

                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(Contact.this,Contact.class); // same as before but creating it for the contact class.
                startActivity(contactIntent); // starts contactIntent which changes to the contact page.
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactButton = (Button)findViewById(R.id.button); // linking the button with the xml for contact page.
        contactButton.setOnClickListener(new View.OnClickListener() { // when the button is pressed it runs "Contact()".
            @Override
            public void onClick(View v) {
                Contact();
            }
        });

    }

}



