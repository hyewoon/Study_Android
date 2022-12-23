package com.example.and11_allview.gridv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.and11_allview.R;


public class GridFragment extends Fragment {
    //어댑터와 리스트 뷰연결
    //리스트뷰 가지고 와야 한다
    GridView gridv;
    GridApater adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_grid, container, false);
        gridv = v.findViewById(R.id.gridv);
        //어댑터는 클래스 --> 생성해서 찾아온다
        adapter = new GridApater(getLayoutInflater());
        gridv.setAdapter(adapter);
        return  v;
    }
}