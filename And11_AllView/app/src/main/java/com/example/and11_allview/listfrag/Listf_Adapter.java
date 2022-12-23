package com.example.and11_allview.listfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.and11_allview.R;

//어댑터 만들기
public class Listf_Adapter extends BaseAdapter {

    LayoutInflater inflater; //adapter와 세트는 레이아웃 인플레이터이다

    public Listf_Adapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_list_f,parent, false);
      /*  TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_time = convertView.findViewById(R.id.tv_time);*/

        return convertView;
    }
    //adapter만들기
    
    
    
}
