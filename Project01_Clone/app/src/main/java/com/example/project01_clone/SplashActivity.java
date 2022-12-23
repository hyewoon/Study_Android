package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    //스플래쉬 화면 : 사용자에게 자연스럽게 광고 배너가 이미지를 노출 시킴으로 브랜드이미지를 친근하게 만든다
    //해당하는 이미지를 노출하는 동안 백그라운드에선느 데이터 로딩작업을 할 수 있다
    //맨처음화면인 스플래쉬

    //핸들러handler : 메인 쓰레드를 이용해서 딜레이를 주는 기능을 이용할 때 사용.
    //방법을 외우거나 도는 깊이 공부할 필요없음

    //화면에 앱이 보여주는 액티비티의 순서나 등록 된 모든 컴포넌트 관리 : androidMainfest

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //PrgressDialog : ※ 사용자 입장에서 중요한 UI요소
        //사용자입장에선 앱이 멈춘건지 아니면 데이터 로딩을 위해서 시간이 소요되는 건지 판단 할 수가 없음
        //빈번하게 많이  사용 됨
        ProgressDialog dialog= new ProgressDialog(this);
        dialog.setTitle("khwTalk 데이터 로딩");
        dialog.setMessage("로딩 중 ");
        dialog.setCancelable(false);//기본적으로 사용자가 취소가능
        dialog.show();

        
        //3가지 : 스플래쉬에서 메인으로 넘겨주기
        // 쓰레드, handler, RunOnUiThread
    /*    Runnable r = new Runnable() {
            @Override
            public void run() {
                
            }
        };

       long delayMills = 1000;*/

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SplashActivity.this, "5초지남", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //안보이게 처리
                //Slpash ->매인 화면 전환

                //inflater 붙이는 것 layout 보이게 붙이는 것
                //activity끼리 전환 ==> 통신 ==> 인텐트
                 Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                 startActivity(intent);




            }
        }, 1000*1 );
    }
}