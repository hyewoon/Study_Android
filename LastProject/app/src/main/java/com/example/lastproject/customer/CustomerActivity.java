package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {

    RecyclerView recv_cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        //스프링 통해서 커스텀 테이블에 있는 데이터조회해서 안드로이드 가져오기
        ApiClient.setBASEURL("http://192.168.0.14/middle/");

        recv_cu = findViewById(R.id.recv_cu);

        selectList();



        Log.d("로그", "onCreate: 여기가 먼저 실행이 될까??");
    }

    public void selectList(){
        new CommonMethod().sendPost("select.cu", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d("로그", "onCreate: " + data);
                // TypeToken
                ArrayList<CustomerVO> list = new Gson().fromJson(data ,
                        new TypeToken<ArrayList<CustomerVO>>(){}.getType()  );
                //비동기 영역 (result는 최대 10초 후에 실행될수도있음.)
                recv_cu.setAdapter(new CuAdapter(getLayoutInflater() , list, CustomerActivity.this));
                recv_cu.setLayoutManager(new LinearLayoutManager(CustomerActivity.this,RecyclerView.VERTICAL,false));
            }
        });
    }
}
