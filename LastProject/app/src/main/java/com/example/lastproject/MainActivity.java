package com.example.lastproject;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
//팀브로젝트 할때 바꾸기
        ApiClient.setBASEURL("http://192.168.0.8/middle/");


        new CommonMethod().setParams("data" , "kk")
        .sendGet("andVo", new CommonMethod.CallBackResult() {

            @Override
            public void result(boolean isResult, String data) {
                if(isResult){
                    Log.d("로그", "result: " + data);
                }
            }
        });




    }
}