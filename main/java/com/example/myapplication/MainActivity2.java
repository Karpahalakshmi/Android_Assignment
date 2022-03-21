package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;

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
        setContentView(R.layout.activity_main2);
        t1=(TextView) findViewById(R.id.txt1);
        t2=(TextView) findViewById(R.id.txt2);
        t3=(TextView) findViewById(R.id.txt3);
        t4=(TextView) findViewById(R.id.txt4);
        t5=(TextView) findViewById(R.id.txt5);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        String age=sharedPreferences.getString(KEY_AGE,null);
        String bio=sharedPreferences.getString(KEY_BIO,null);
        String mno=sharedPreferences.getString(KEY_MNO,null);
        String location=sharedPreferences.getString(KEY_LOCATION,null);

        if(name!=null && age!=null && bio!=null && mno!=null && location!=null)
        {
            t1.setText("Name:"+name);
            t2.setText("Age:"+age);
            t3.setText("Bio"+bio);
            t4.setText("Mobile_no:"+mno);
            t5.setText("Location:"+location);
        }
    }
}