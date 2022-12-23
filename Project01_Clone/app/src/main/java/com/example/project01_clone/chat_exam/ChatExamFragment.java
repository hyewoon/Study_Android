package com.example.project01_clone.chat_exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;

import java.util.ArrayList;


public class ChatExamFragment extends Fragment {
    RecyclerView recv_exam_chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat_exam, container, false);
        recv_exam_chat = v.findViewById(R.id.recv_exam_chat);

        ArrayList<ChatExamDTO> list = new ArrayList<>();
        for(int i =0; i<10; i++){
            list.add(
                new ChatExamDTO(R.drawable.profile_img1,"이름" +(i+1), "메시지", "오후2:00")

        );
        }


        ChatExamAdapter adapter = new ChatExamAdapter(inflater, list);
        adapter.setContext(getContext());
        recv_exam_chat.setAdapter(adapter);


        recv_exam_chat.setLayoutManager(CommonMethod.getManger(getContext()));
        return v;
     /*   recv_exam_chat.setLayoutManager(CommonMethod.getManger(getContext(), RecyclerView.VERTICAL));
        return v;
    }*/

     /*   public boolean add(ChatExamDTO e){
            return false;
        }*/
    }
}