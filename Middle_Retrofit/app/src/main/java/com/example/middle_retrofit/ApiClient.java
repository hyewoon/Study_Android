package com.example.middle_retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public  Retrofit getApiClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.8/middle/")//톰캣까지 서버접근 경로
               .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build()) //서버연결안될시
                .addConverterFactory(ScalarsConverterFactory.create())//json String 사용
                .build();

        return retrofit;
    }

}
