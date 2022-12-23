package com.example.project01_clone.friendlist;

import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.Random;


public class FriendFragment extends Fragment {

    RecyclerView recv_friend_frag;
    ArrayList<FriendDTO> list = new ArrayList<>();
    int[] imgArr = {
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
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_friend, container, false);
        //30건 Arraylist에 담기
        Random random =new Random();

      /*  int imgRes = 10;
        String name = "이름";
        String msg ="메세지";
        FriendDTO e = new FriendDTO(10, "이름", "msg");
*/
        for(int i = 0; i<30; i ++){
            list.add(new FriendDTO(imgArr[random.nextInt(imgArr.length)],"친구이름"+(i+1), "상태"+(i+1)));
        }



        //어댑터와 리사이클러뷰 연결
        recv_friend_frag = v.findViewById(R.id.recv_friend_frag);

        FriendAdapter adapter= new FriendAdapter(inflater, list, getContext());
        recv_friend_frag.setAdapter(adapter);

        recv_friend_frag.setLayoutManager(new LinearLayoutManager(getContext()
        , RecyclerView.VERTICAL,false));

        return v;
    }
}