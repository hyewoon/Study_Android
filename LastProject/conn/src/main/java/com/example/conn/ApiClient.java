package com.example.conn;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static String BASEURL="";

  public static void setBASEURL(String BASEURL){
      ApiClient.BASEURL = BASEURL;
  }

    public  Retrofit getApiClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)//톰캣까지 서버접근 경로
               .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build()) //서버연결안될시
                .addConverterFactory(ScalarsConverterFactory.create())//json String 사용
                .build();

        return retrofit;
    }

}
