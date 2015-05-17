package com.example.neeraj.mark3.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.neeraj.mark3.R;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by NEERAJ on 08-May-15.
 */

public class Login extends Activity {

    Button signupbutton, loginbutton;
    EditText usernameet, passwordet;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        signupbutton = (Button) findViewById(R.id.bsignup);
        loginbutton = (Button) findViewById(R.id.blogin);
        usernameet = (EditText) findViewById(R.id.edittext_username);
        passwordet = (EditText) findViewById(R.id.edittext_password);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = usernameet.getText().toString();
                password = passwordet.getText().toString();

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Intent i = new Intent(Login.this, Mainpage.class);
                            startActivity(i);
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast toast1 = Toast.makeText(getApplicationContext(), "wrong username or password", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    }
                });
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
            }
        });
    }
}