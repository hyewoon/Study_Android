package com.example.and10_flagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class SubFragment extends Fragment {

    Button btn_sub_frag;
    ImageView img1, img2;
    int cnt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_sub, container, false);
        btn_sub_frag = v.findViewById(R.id.btn_sub_frag);
        img1 = v.findViewById(R.id.img1);
        img2 = v.findViewById(R.id.img2);

        btn_sub_frag.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //loop int 0 --> 1--> 0-->1
                //이미지 뷰 자체를 이용

                if(img1.getVisibility() == View.VISIBLE){
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                }else if (img1.getVisibility() != View.VISIBLE){
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);
                }


      /*          cnt ++;
                //홀수, 짝수일때 1,2 번 화면 전환
                if(cnt % 2 == 0){
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);
                }else {
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                }*/

            }
        });
        return v;
    }
}