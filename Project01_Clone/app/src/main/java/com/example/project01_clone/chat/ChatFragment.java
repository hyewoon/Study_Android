package com.example.project01_clone.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.Random;

public class ChatFragment extends Fragment {
    //리사이클러뷰(레이아웃)과 어댑터 연결하는 부분
    //리사이클러뷰를 가져온다
    //어댑터를 가져온다(어댑터는 항상 inflater필요)
    RecyclerView recv_chat_frag;
    Chatadapter adapter;
    int[] imgArray = {
            R.drawable.profile_img1,
            R.drawable.profile_img2,
            R.drawable.profile_img3,
            R.drawable.profile_img4,
            R.drawable.profile_img5,
            R.drawable.profile_img6,
            R.drawable.profile_img7,
            R.drawable.profile_img8,

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_chat, container, false);

        //ArrayList에 담기
        ArrayList<ChatDTO> list = new ArrayList<>();
        Random random= new Random();

        for(int i = 0 ; i <20 ; i++ ){
            list.add(new ChatDTO(imgArray[random.nextInt(imgArray.length)],"친구"+(i+1), "상태메시지"+(i+1), (i+1)+ ":00"));
        }






        recv_chat_frag= v.findViewById(R.id.recv_chat_frag);
        //Oncreate에 LayoutInflater inflater 선언되어있으니 그냥 변수만가져오면된다
       adapter = new Chatadapter(inflater, list, getContext());
       recv_chat_frag.setAdapter(adapter);

       //★ 이부분 무슨 의미인지 이해 안됨
       recv_chat_frag.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        return v;
    }
}