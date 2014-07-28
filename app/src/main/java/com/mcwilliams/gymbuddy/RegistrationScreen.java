package com.mcwilliams.gymbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by joshuamcwilliams on 7/27/14.
 */
public class RegistrationScreen extends Activity {
    private RelativeLayout needGymInfo;
    private RelativeLayout haveGymInfo;
    private TextView gymName;
    private TextView gymAddress;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText firstName;
    private EditText lastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);
        needGymInfo = (RelativeLayout) findViewById(R.id.rlGetGymInfo);
        haveGymInfo = (RelativeLayout) findViewById(R.id.rlGotGymInfo);
        gymName = (TextView) findViewById(R.id.tvGymName);
        gymAddress = (TextView) findViewById(R.id.tvGymAddress);
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        username = (EditText) findViewById(R.id.etUserName);
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registration_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.register) {
            onDoneClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onFindGymCLicked(View view){
        Intent goToFindGym = new Intent(this, GymLocator.class);
        startActivityForResult(goToFindGym, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == RESULT_OK){
           gymName.setText(data.getStringExtra("gymName"));
           gymAddress.setText(data.getStringExtra("gymAddress"));
           haveGymInfo.setVisibility(View.VISIBLE);
           needGymInfo.setVisibility(View.GONE);

       }
    }


    public void onDoneClicked (){
        final String parseUsername = username.getText().toString();
        final String parsePassword = password.getText().toString();
        String parseEmail = email.getText().toString();
        String parseGymName = gymName.getText().toString();
        String parseGymAddress = gymAddress.getText().toString();
        String parseFirstName = firstName.getText().toString();
        String parseLastName = lastName.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(parseUsername);
        user.setPassword(parsePassword);
        user.setEmail(parseEmail);
        user.put("gymName", parseGymName);
        user.put("gymAddress", parseGymAddress);
        user.put("firstName", parseFirstName);
        user.put("lastName", parseLastName);

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    //start new activity

                    ParseUser.logInInBackground(parseUsername, parsePassword, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                //start new activity
                                Intent intent = new Intent(getBaseContext(), HomeScreen.class);
                                //intent.putExtra("user", user);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Wrong username/password combo",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),
                            "There was an error signing up."
                            , Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
