package com.example.neeraj.mark3.activities;

import android.app.Activity;
<<<<<<< HEAD
=======
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
>>>>>>> fb13623... first commit
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.neeraj.mark3.R;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
=======
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neeraj.mark3.R;
>>>>>>> fb13623... first commit

/**
 * Created by NEERAJ on 08-May-15.
 */
public class Signup extends Activity {


    private static int rli = 1;

    ImageView buttonselecti;
<<<<<<< HEAD
    EditText name1, day1, month1, year1, password1,email,mobileno;
    Button bsignup;

    String string_username, string_password,string_email,string_mobile;
=======
    EditText name1, day1, month1,year1;

    final Context context = this;
>>>>>>> fb13623... first commit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

<<<<<<< HEAD
        buttonselecti = (ImageView) findViewById(R.id.imageview_propicfb);
        name1 = (EditText) findViewById(R.id.EditTextname);
        password1 = (EditText) findViewById(R.id.EditTextpassword);
        email = (EditText) findViewById(R.id.editTextViewemailid);
        mobileno = (EditText) findViewById(R.id.editTextViewmobileno);
        bsignup = (Button) findViewById(R.id.buttonsignup);
=======

        buttonselecti = (ImageView) findViewById(R.id.imageview_propicfb);
        name1 = (EditText) findViewById(R.id.EditTextname);
        day1 = (EditText) findViewById(R.id.editTextViewdate);
        month1 = (EditText) findViewById(R.id.editTextViewmonth);
        year1 = (EditText) findViewById(R.id.editTextViewyear);
>>>>>>> fb13623... first commit

        //for images
        buttonselecti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
<<<<<<< HEAD
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, rli);
            }
        });

        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                string_username = name1.getText().toString();
                string_password = password1.getText().toString();
                string_email = email.getText().toString();
                //string_mobile = mobileno.getText().toString();

                ParseUser user = new ParseUser();
                user.setUsername(string_username);
                user.setPassword(string_password);
                user.setEmail(string_email);

// other fields can be set just like with ParseObject
                //user.put("Mobile No.", string_mobile);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Intent i = new Intent(Signup.this, Mainpage.class);
                            startActivity(i);

                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast toast1 = Toast.makeText(getApplicationContext(), "error in signing up...", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                    }
                });
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
=======
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, rli);
            }
        });
    }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
>>>>>>> fb13623... first commit
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == rli && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();
<<<<<<< HEAD
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
=======

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);

            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

>>>>>>> fb13623... first commit
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.ivprofile);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
}