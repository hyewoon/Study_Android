package com.example.and10_flagment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // layoutinflater :
    // 화면에 띄우는 것?? 정확히 모르겠음
    // 두 개 화면 사이에서
    // 어떤 레이아웃을 따로 불러와서 사용
    // 붙을 공간 필요 ==> viewGroup(layout)
    // 붙일 내용 ==> .xml(layout)
    //※ fragment 반드시 layoutflater가 있는 상태로 붙음
    //반드시 액티비티 안에 있는 형태
    //만드는 방법 ; 패키지 오마 클릭 후 fRagment 찾기
    //layinflate
    //독립된 자바코드 가진다


    Button btn_frag1, btn_frag2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1= findViewById(R.id.btn_frag1);
        btn_frag2= findViewById(R.id.btn_frag2);


        //btn_frag1 클릭 시 MainFragment가 붙을 수 있게 코딩
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //플레그먼트 붙이는  처리
                //트랜잭션 ?? 이후에해줘야 하는 것 :commit
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).commit();
            }
        });

        //btn_frag2 클릭 시 SubFragment가 붙을 수 있게 코딩
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new SubFragment()).commit();
            }
        });

    }
}