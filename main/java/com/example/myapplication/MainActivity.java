package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4,editText5;
    String name,age,bio,mno,loc;
    Button login;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypreference";
    private static final String KEY_NAME="name";
    private static final String KEY_AGE="age";
    private static final String KEY_BIO="bio";
    private static final String KEY_MNO="mobile_no";
    private static final String KEY_LOCATION="location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText) findViewById(R.id.et1);
        editText2=(EditText) findViewById(R.id.et2);
        editText3=(EditText) findViewById(R.id.et3);
        editText4=(EditText) findViewById(R.id.et4);
        editText5=(EditText) findViewById(R.id.et5);
        login=(Button) findViewById(R.id.btn);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=editText1.getText().toString();
                age=editText2.getText().toString();
                bio=editText3.getText().toString();
                mno=editText4.getText().toString();
                loc=editText5.getText().toString();
                if (name.toString().trim().length() == 0 &&
                        age.toString().trim().length() == 0 &&
                        bio.toString().trim().length() == 0 &&
                        mno.toString().trim().length() == 0 &&
                        loc.toString().trim().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Enter all the fields", Toast.LENGTH_LONG).show();
                }
                else
                {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(KEY_NAME,editText1.getText().toString());
                    editor.putString(KEY_AGE,editText2.getText().toString());
                    editor.putString(KEY_BIO,editText3.getText().toString());
                    editor.putString(KEY_MNO,editText4.getText().toString());
                    editor.putString(KEY_LOCATION,editText5.getText().toString());
                    editor.apply();

                    Intent in1=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(in1);
                }
            }
        });
    }
}