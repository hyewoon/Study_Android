package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.middle_retrofit.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    //위젯안찾고 하나로 묶어놓음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //  Retrofit.create();
        // 일부 코드만 있음.
        CommonMethod commonMethod = new CommonMethod();
        commonMethod.setParams("data" , "kk");
        commonMethod.getData("andVo", new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", " 성공:  " + response.body());
                CustomerVO vo =new Gson().fromJson(response.body(),CustomerVO.class);
                binding.tv.setText(vo.getEmail());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", " 실패:  " + t.getMessage());
            }
        });


    }
}