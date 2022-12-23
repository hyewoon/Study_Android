package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SubMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);


        Intent intent =getIntent();
        //MainActivity에서 Subactivity를 띄울때
        String sVal = intent.getStringExtra("sVal");
        Log.d("로그", "값: " + sVal);

        int sVal1 = intent.getIntExtra("sVal1", -2);
        //int 타입은 널을 허용하지 않음, 기본으로 담을 값
        Log.d("로그", "값: " + sVal1);

    }
}