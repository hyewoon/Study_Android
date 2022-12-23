package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        LinearLayout In_layout1 = findViewById(R.id.In_layout1);
        LinearLayout In_layout2 = findViewById(R.id.In_layout2);

        LayoutInflater inflater = getLayoutInflater();
        View v1 =  inflater.inflate(R.layout.layout_sub1, In_layout1, true);

        View v2 = inflater.inflate(R.layout.layout_sub2, In_layout2, true);


        TextView text1 = v1.findViewById(R.id.text1);
        text1.setText("글씨");
        Button btn3 = v1.findViewById(R.id.btn3);
        btn3.setText("버튼클릭");
        //레이아웃을 붙이는처리를 하면 레이아웃 붙은 레이아웃이 메모리에 올라가면
        
        //버튼클릭하면 글자 바꾸기

        Button btn_new =findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity --> intent --> subactivity
                //인텐트라는 객체를 통해서 다음액티비티 띄우기
                //main -- intent --sub
                //MemberDTO

                 ArrayList<MemberDTO> list = new ArrayList<>();

                 for(int i=0  ; i<10 ; i++){
                     list.add(new MemberDTO(2, "a", "b"));

                 }
                  MemberDTO dto = new MemberDTO(2, "a", "b");
                Intent intent = new Intent(MainActivity.this, SubMainActivity.class);
                intent.putExtra("sVal" , "hye");
                intent.putExtra("sVal1",100 );
                dto = (MemberDTO)intent.getSerializableExtra("dto");
                list  =( ArrayList) intent.getSerializableExtra("list");

                Log.d("로그", "onClick: " + dto);

                        //데이터 넣기
                startActivity(intent);
                //intent 통신
            }
        });
        Button btn4 = v2.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text2 =v2.findViewById(R.id.text2);
                text2.setText("글씨 바꾸기");
                //버튼 클릭시 토스트 메세지 나오기
                Toast.makeText(MainActivity.this, "토스트", Toast.LENGTH_SHORT).show();
                 NoneContext none = new NoneContext(getLayoutInflater());
                 none.method1();
                 none.showToast(MainActivity.this);
                 none.v1Setting(v1);
            }
        });
        //context
        //context : 현재 화면에 떠있는 객체에게 어떤 기능들을 사용할 수있는 권한을 줌
        //context : activity룰 넘겨주면 된다
        Toast.makeText(this, "안드로이드", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "토스트", Toast.LENGTH_SHORT).show();

    }

}