package com.example.and02_relativelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv= new TextView(this);
        tv.setText("K H WK H WK H WK H WK H WK H WK H WK H WK H WK H W");
        Button btn = new Button(this);
        btn.setText("자바코드로 버튼넣음");
        //위젯(textView1, button)
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.addView(tv);
        layout.addView(btn);
        setContentView(layout); //Viewgroup view 상속

        //setContentView(R.layout.activity_main);

//        Object obj = null;
//        //obj에 담을 수 있는 값? 모든지 담을 수 있다
//        obj ="a";
//        obj = 12;
//        //obj는 모든 타입을 담을 수 있는 객체(최상위)
//        //왜? 변수타입을 나눠서 사용할까?  타입별로 알아보기 위해서
//        Object ob = "";
//        String st = "";
//        //str object를 상속받은 자식 객체
//        //1세대 폰보다 2세대 폰이 기능이 더 좋다다

    }
}