package com.example.neeraj.mark3.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neeraj.mark3.R;

/**
 * Created by NEERAJ on 08-May-15.
 */
public class Signup extends Activity {


    private static int rli = 1;

    ImageView buttonselecti;
    EditText name1, day1, month1,year1;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        buttonselecti = (ImageView) findViewById(R.id.imageview_propicfb);
        name1 = (EditText) findViewById(R.id.EditTextname);
        day1 = (EditText) findViewById(R.id.editTextViewdate);
        month1 = (EditText) findViewById(R.id.editTextViewmonth);
        year1 = (EditText) findViewById(R.id.editTextViewyear);

        //for images
        buttonselecti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, rli);
            }
        });
    }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == rli && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);

            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.ivprofile);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
}