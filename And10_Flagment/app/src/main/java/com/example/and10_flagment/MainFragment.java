package com.example.and10_flagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainFragment extends Fragment {

     Button btn_main_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    
        //fragmentmain에 만든 버튼은 mainfragment에서 찾는다
        View v =  inflater.inflate(R.layout.fragment_main, container, false);
        btn_main_frag = v.findViewById(R.id.btn_main_frag);

        //액티비티 위에 떠있는 권한만 있다
        btn_main_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "토스트띄우기", Toast.LENGTH_SHORT).show();
            }
        });
        return v;


    }
}