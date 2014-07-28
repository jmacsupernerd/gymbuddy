package com.mcwilliams.gymbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by joshuamcwilliams on 7/27/14.
 */
public class RegistrationScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gym_locator, menu);
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

    public void onFindGymCLicked(View view){
        Intent goToFindGym = new Intent(this, GymLocator.class);
        startActivity(goToFindGym);
    }

    public void onDoneClicked (){
//        username = usernameField.getText().toString();
//        password = passwordField.getText().toString();
//
//        ParseUser user = new ParseUser();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        user.signUpInBackground(new SignUpCallback() {
//            public void done(ParseException e) {
//                if (e == null) {
//                    //start new activity
//                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT);
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "There was an error signing up."
//                            , Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }
}
