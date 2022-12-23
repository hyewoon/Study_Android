package com.example.and11_allview.myrecycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and11_allview.R;

import java.util.ArrayList;


public class MyRecvFragment extends Fragment {


    RecyclerView my_recv;
    ArrayList<MusicDTO> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_my_recv, container, false);
        my_recv = v.findViewById(R.id.my_recv);
        //어댑터 연결
        list= new ArrayList<>();
        list.add(new MusicDTO("1","앨범1","윤하"));
        list.add(new MusicDTO("2", "앨범2", "윤하"));


        my_recv.setAdapter(new MyRecvAdapter(inflater,list));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false );

        my_recv.setLayoutManager(manager);

        return v;
    }
}