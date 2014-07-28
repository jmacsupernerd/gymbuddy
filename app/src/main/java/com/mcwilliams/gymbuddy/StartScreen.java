package com.mcwilliams.gymbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class StartScreen extends Activity {

    private EditText usernameField;
    private EditText passwordField;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Parse.initialize(this, "rU3DEhn29a3DzNHEvWNE3GJKGMFHngTSsWFseLtk", "d0QIgzVKpPoQtzalzfpgQfgClS12diOzIIsyFKGw");
        usernameField = (EditText) findViewById(R.id.userName);
        passwordField = (EditText) findViewById(R.id.password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onLoginClick(View view){

        username = usernameField.getText().toString();
        password = passwordField.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    //start new activity
                    Intent intent = new Intent(getBaseContext(), HomeScreen.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Wrong username/password combo",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void onRegisterClicked(View view){

        Intent goToRegistration = new Intent(this, RegistrationScreen.class);
        startActivity(goToRegistration);
    }
}


