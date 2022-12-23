package com.example.project01_clone.friendlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project01_clone.R;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView detail_profile;
    TextView  detail_name, detail_text;
    LinearLayout ln_menu1,ln_menu2,ln_menu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide(); //액션바를 가져와서 안보이게 처리


        Intent intent =getIntent();
        FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");

        detail_profile= findViewById(R.id.detail_profile);
        detail_name= findViewById(R.id.detail_name);
        detail_text= findViewById(R.id.detail_text);
        ln_menu1= findViewById(R.id.ln_menu1);
        ln_menu2= findViewById(R.id.ln_menu2);
        ln_menu3= findViewById(R.id.ln_menu3);

        detail_profile.setImageResource(dto.getImgRes());
        detail_name.setText(dto.getName());
        detail_text.setText(dto.getMsg());

        ln_menu1.setOnClickListener(this);
        ln_menu2.setOnClickListener(this);
        ln_menu3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Intent <== 컴포넌트들간의 통신을 맡고 있는 객체(액티비티)
        //1. 명싲거 인텐트 (우리가 만든 클래스 내부에서 사용하고 그 통제가 전부 가능한 상태)
        //(Intent intent = new Intent (현재위치(context), 다음에 띄울 액티비티.class)
        //startActivity
        
        //2.묵시적(암시적) 인텐트, (우리가 만든 게 아니다, os다른 외부에서 제공하는 기능과 통신(호출))
        //우리가 만든것이 아니기 때문에 어던 결과 나올지 모름
        //
        Intent intent = null;
        //인터넷 띄우는 것

        if(v.getId() ==R.id.ln_menu1){
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com") );
        }else if(v.getId() ==R.id.ln_menu2){
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01087156627"));

        }else if(v.getId() ==R.id.ln_menu3){
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "월드컵");
        }
        startActivity(intent);

    }
}