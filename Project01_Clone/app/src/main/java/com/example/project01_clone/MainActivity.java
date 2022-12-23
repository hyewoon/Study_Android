package com.example.project01_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project01_clone.chat.ChatFragment;
import com.example.project01_clone.chat_exam.ChatExamFragment;
import com.example.project01_clone.external.ExternalFragment;
import com.example.project01_clone.friendlist.FriendFragment;
import com.example.project01_clone.view.ViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        actionBar = getSupportActionBar(); //기본으로 있는 액션바를 가져옴
        actionBar.setTitle("친구");

        btm_nav= findViewById(R.id.btm_nav);
        //listner는 모두
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btm_item1){
                    actionBar.setTitle("친구");
                    //패키지 추가 => friendlist 추가
                    //FriendFragment 추가
                    //해당하는 플래그먼트 붙게 처리
                   /* Fragment fragment = new FriendFragment();
                    changeFragment(fragment);*/
                    changeFragment(new FriendFragment());


                }else if(item.getItemId() == R.id.btm_item2){
                    actionBar.setTitle("채팅");
                    changeFragment(new ChatExamFragment());

                }else if(item.getItemId() == R.id.btm_item3){
                    actionBar.setTitle("뷰");
                    changeFragment(new ViewFragment());
                }else if(item.getItemId() == R.id.btm_item4){
                    actionBar.setTitle("쇼핑");
                    changeFragment(new ExternalFragment());
                }else if(item.getItemId() == R.id.btm_item5){
                    actionBar.setTitle("더보기");

                }

                return true; // false 선택을 취소함
            }
        });
    }//onCreate

    //프래그먼트를 changeFragment라는 메소드를 이용해서 동적으로 붙이는 처리를 하고 싶다
    //어느 부분이 바뀌면 좋을까? -- 파라미터에
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}