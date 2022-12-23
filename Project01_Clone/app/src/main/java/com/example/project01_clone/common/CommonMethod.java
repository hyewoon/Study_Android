package com.example.project01_clone.common;

import static java.security.AccessController.getContext;

import android.content.Context;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {
    
   
    //매번 화면에서 Layout 매니저 직접 만드는 행위가 불편
    //재사용이 가능한 메소드 하나를 이용해서 코드를 줄여 보고자 한다
    //레이아웃매니저를리턴하는 메소드를 정의해보고
    //chatExamFragment에서  호출해서 사용하기

   /* RecyclerView.LayoutManager manager = new LinearLayoutManager(
            getContext(),RecyclerView.VERTICAL,false
    );
    */
   //recv_exam_chat.setLayoutManger(CommonMethod.getManger());
   //context Activity와 fragment에서만 사용할 수 있다 --> 두개에서 받아와야 한다
   // 일반 클래스는 화면에 보지이 않는다. 그러니까 당연히 layout매니저 가져오지 못한다

    //메소드 호출하기
    //전체가 대문자 -- 파이널 상수이다
    
    public static RecyclerView.LayoutManager getManger(Context context){//context를 화면에 보이는 객체로 부터 받아온다
        
        RecyclerView.LayoutManager manger = new LinearLayoutManager(
                 context,RecyclerView.VERTICAL,false);
        return manger;
    }

    public static RecyclerView.LayoutManager getManger(Context context, int orientation){//context를 화면에 보이는 객체로 부터 받아온다

        RecyclerView.LayoutManager manger = new LinearLayoutManager(
                context,orientation,false);
        return manger;
    }

}
