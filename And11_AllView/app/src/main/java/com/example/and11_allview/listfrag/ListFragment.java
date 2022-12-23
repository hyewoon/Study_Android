package com.example.and11_allview.listfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.and11_allview.R;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    ListView list_frag;
    Listf_Adapter listf_adapter;
    ArrayList<ListfDTO> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listf, container, false);
        list_frag =v.findViewById(R.id.list_frag);
        //4 어댑터 연결하기
        listf_adapter = new Listf_Adapter(getLayoutInflater());
        list_frag.setAdapter(listf_adapter);

        return v;




    }
}