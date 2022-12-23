package com.example.and08_activityintent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class NoneContext {



    LayoutInflater inflater;
    //생성자만들기
    public NoneContext(LayoutInflater inflater){
        this.inflater = inflater;
    }


    public void method1(){
        if(inflater  == null){
            Log.d("인플레이터", "method1: null");
        }else{

            Log.d("인플레이터", "method1:null 아님 ");
        }
    }



    public void showToast(MainActivity activity){
        Toast.makeText(activity, "토스트 호출", Toast.LENGTH_SHORT).show();
    }

    //v1에 대해서 noneContext는 모른다
    //v1을 가져와야 한다



    public void v1Setting(View v1){

        TextView text1 = v1.findViewById(R.id.text1);
        text1.setText("글씨");
        Button btn3 = v1.findViewById(R.id.btn3);
        btn3.setText("버튼클릭");
    }

}
