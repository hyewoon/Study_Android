package com.example.and05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /* tml에서 만든 태그명은 반드시 java 객체로 존자한다-->*/
    TextView tv; //변수의 선언
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv); //textview 초기화 (디자인 이랑 자바랑)
        tv.setText("글씨set text");  //기존 글씨 지우고 새롭게  쓰기



        for(int i = 0; i<=50; i++){

            tv.append("\n 안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요"); //기존글자 + 새로운 글자

        }

    }

}