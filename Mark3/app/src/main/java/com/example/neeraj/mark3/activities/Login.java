package com.example.neeraj.mark3.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neeraj.mark3.R;

/**
 * Created by NEERAJ on 08-May-15.
 */

public class Login  extends Activity{

    Button bsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        bsignup = (Button) findViewById(R.id.bsignup);
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });
    }
}
