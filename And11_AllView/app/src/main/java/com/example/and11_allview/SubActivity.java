package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    //객체가 필요하다면 필드 지정하고 생성자로 받아온다
    //액티비티는 new로 받아올 수 없다
   ListView list_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        ArrayList<ListDTO> list = new ArrayList<>();
        ListDTO dto = new ListDTO("name", "cnt");

        for(int i = 0; i <20; i++){
            list.add(new ListDTO("name" + i, "cnt" + i));
        }

        //ListAdapter생성하기
        list_sub= findViewById(R.id.list_sub);
        List_Adapter adapter = new List_Adapter(getLayoutInflater(), list);
        list_sub.setAdapter(adapter);

        //listDTO 30개를 가진 arrayList 만들기

         //list_adapter의 아이템 갯수 == list.size와 같게 처리하기-->DB에서 가져왔을 때 사이즈 맞게 하려면
        Log.d("로그", "리스트사이즈: " +list.size());





    }
}