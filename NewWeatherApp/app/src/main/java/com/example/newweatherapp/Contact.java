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

    private Button contactButton;
    private EditText issue;
    private EditText description;
    private EditText email;

    private void Contact() {

        issue = findViewById(R.id.editTextIssue);
        description = findViewById(R.id.editTextDescription);
        email = findViewById(R.id.editTextEmail);

        if (TextUtils.isEmpty(issue.getText())){
            issue.setError("Missing issue!");
        } else
        if(TextUtils.isEmpty(description.getText())){
            description.setError("Missing Description!");
        }else
        if(TextUtils.isEmpty(email.getText())){
            email.setError("Missing Email!");
        }else{

            sendContact();

        }



    }

    private void sendContact(){

        String issue = ((EditText)findViewById(R.id.editTextIssue)).getText().toString();
        String description = ((EditText)findViewById(R.id.editTextDescription)).getText().toString();
        String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString();

        Intent contact = new Intent(Intent.ACTION_SEND);

        contact.putExtra(Intent.EXTRA_EMAIL,new String[]{"10749683@cityplym.ac.uk"});
        contact.putExtra(Intent.EXTRA_SUBJECT,"Contact Us - Issue: "+issue);
        contact.putExtra(Intent.EXTRA_TEXT,"Description:" +description + "\n\nCustomer's Email: " +email);
        contact.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(contact, "Send Email: "));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(Contact.this, "Unable to send Email.",Toast.LENGTH_SHORT).show();
        }
        finish();
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
                Intent mapIntent = new Intent(Contact.this,WeatherApp.class);
                startActivity(mapIntent);
                //Toast.makeText(this, "This works menu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Intent loginIntent = new Intent(Contact.this,Login.class);
                startActivity(loginIntent);
                //Toast.makeText(this, "This works item1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:


                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:

                Intent contactIntent = new Intent(Contact.this,Contact.class);
                startActivity(contactIntent);
                //Toast.makeText(this, "This works item2",Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactButton = (Button)findViewById(R.id.button);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact();
            }
        });

    }

}



