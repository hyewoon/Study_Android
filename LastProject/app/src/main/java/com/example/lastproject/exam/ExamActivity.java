package com.example.lastproject.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {



    Button test1, test2, test3, test4, test5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        ApiClient.setBASEURL("http://192.168.0.14/middle/");

        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);
        test3 = findViewById(R.id.test3);
        test4 = findViewById(R.id.test4);
        test5 = findViewById(R.id.test5);


        test1.setOnClickListener(v -> {
            //test1요청
       /*     new CommonMethod().sendPost("test1", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result: " +isResult);
                }
            });*/
            new CommonMethod().sendPost("test1", (isResult, data) -> {
                Log.d("로그", "onCreate: " + isResult); //리턴값 없으니까 true false 로 확인
            });
        });
        //url:middle/test2?param1=value1...2..3
        /*
        test2.setOnClickListener(v-> {
            //test2로 3개의 파라메터를 보내고 요청해보기
            new CommonMethod().setParams("a", "id").setParams("abc", "pw").setParams("5", "cnt").sendPost("test2", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {

                }
            });*/
       /*     CommonMethod method = new CommonMethod();
            method.setParams("id", "a");
            method.setParams("pw", "abc");
            method.setParams("cnt", "5");
        });*/
        
        test3.setOnClickListener(v -> {
            new CommonMethod().sendPost("test3", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result: " + data);
                }
            });
        });
        
        test4.setOnClickListener(v -> {
            //Data타입이 각각 다른 (int iVal ,sVal, dVal)를 가진 VO를 만들고 (spring 4)
            //받아오기
            new CommonMethod().sendPost("test4", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result: " + data);
                    //fromJson(String 이나 json ) 바꾸고 싶은 데이터, 바꾸고 싶은 타입
                    ExamVO vo = new Gson().fromJson(data, ExamVO.class);
                    Log.d("로그", "result: " + vo.getsVal());
                    Log.d("로그", "result: " + vo.getdVal());
                    Log.d("로그", "result: " + vo.getiVal());
                }
            });
        });
        test5.setOnClickListener(v -> {
            new CommonMethod().sendPost("test5", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    Log.d("로그", "result:" + data);
                    ArrayList<ExamVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<ExamVO>>(){}.getType());
                    Log.d("로그", "result: "+list.size());
                }
            });
        });

    }
    }