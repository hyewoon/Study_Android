package com.example.and06_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   Button  btn_text ;
   TextView  tv_text ;
   RadioButton rdo_1;
   RadioButton rdo_2;
   RadioGroup rdo_grp;
   EditText edt_id, edt_pw;
   Button btn_login;
  

    //아직 값이 들어가지 않았다??
    //오류코드: why? : 수명주기(Life Cycle) : onCreate- onStart
    //setContentView <== 디자인 파일과 연결되는 구간 -- 일단 생성된 후에 찾아야
    //렌더링(web) :
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       tv_text = findViewById(R.id.tv_text);
       btn_text = findViewById(R.id.btn_text);
       //모든 위젯은 null아닌 상태일 이벤트를 줄 수 있다


        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);

        //입력값과 같으면 로그인
       // edt_id == "admin" && edt_pw == 1234


        
        btn_login.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

               edt();
               method();
                if(edt_id.getText().toString().equals("admin") &&edt_pw.getText().toString().equals("1234") ){
                    btn_login.setText("로그인 되었습니다");

                    Log.d("로그인", "로그인되었습니다 ");
                }else {
                    Log.d("로그인", "아이디 또는 비밀번호를 확인해주세요");
                }


            }
        });


      



        

       rdo_1 = findViewById(R.id.rdo_1);
       rdo_2= findViewById(R.id.rdo_2);

       rdo_grp = findViewById(R.id.rdo_grp);
       
       rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               Log.d("로그", "onCheckedChanged: " + group.getCheckedRadioButtonId());
               RadioButton temp_rdo= (RadioButton) group.getChildAt(checkedId-1);
               Log.d("로그", "onCheckedChanged: " +temp_rdo.getText());
               //디버깅모드 활용해 문제 해결
               //어떤 라디오버튼이 클릭되었는지 알수 있으려면 어떻게 해야 할까? 
               //로그에 찍어보기
        /*       if(checkedId == 1){
                   Log.d("로그", "onCheckedChanged:아주 나쁨 ");
               }else if(){
                   
               }
*/

           }
       });

       rdo_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              // rdo_1.setChecked();
               //네이밍규칙 : is 들어가면 boolean ischecked라디오 버튼이체크상태다
               //체크
               if(isChecked){
                   rdo_2.setChecked(!isChecked);
               }
           }

       });

        rdo_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //네이밍규칙 : is 들어가면 boolean ischecked라디오 버튼이체크상태다
                if (isChecked) {
                    rdo_1.setChecked(false);
                }
            }
        });



//        btn_text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv_text.setText("버튼이 클릭!!!");
//                //클릭시 버튼 글자 바뀐다
//
//
//            }
//        });
//        tv_text.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                btn_text.setText("텍스트뷰 클릭");
//            }
//        });
        tv_text.setOnClickListener(this);
        btn_text.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.tv_text){
            btn_text.setText("텍스트뷰 클릭 됨");
        }else if(v.getId()== R.id.btn_text){
            tv_text.setText("버튼이 클릭!!!");
        }

    }


    //메소드 만들기
    //wrapper 클래스
     int edt(){
        try{
            Log.d("로그인", "method :" +  Integer.parseInt(edt_pw.getText().toString()) );
            return 0;
        }catch(Exception e){
            
         }
       return -1;
    }

    //메소드만들기
    String method(){
        try{
            Log.d("로그인", "method :" +  Integer.parseInt(edt_pw.getText().toString()) );
            Log.d("로그인", "method : 숫자로 바꿀 수 없는 문자열을 입력해주세요" );
            return "error";
        }catch(Exception e) {
            return edt_id.getText() + "";
        }
    }
}