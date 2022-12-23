package com.example.project01_clone.friendlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.MainActivity;
import com.example.project01_clone.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    //어떤 칸에 디자인 파일(layout) 붙이고 나서 뷰타입 반환하는 것 : layoutinflater

    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;
    //대문자 타입은 ==> new 로 만든다

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.item_recv_friend, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    //데이터를 연결
    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_friend_profile.setImageResource(list.get(i).getImgRes());
        h.tv_friend_name.setText(list.get(i).getName());
        h.tv_friend_msg.setText(list.get(i).getMsg());
        final int idx = i;
        //final은 고정된 값이다.
        h.imgv_friend_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, DetailActivity.class);
                FriendDTO dto = list.get(idx);
                intent.putExtra("dto", dto);
               /* intent.putExtra("dto", list.get(dto));*/
                context.startActivity(intent);


            }
        });


        
        //액티비티를 클릭 했을 때 액티비티 나올 수 있도록 코딩
        //액티비티 띄울때  꼭 필요한 것(현재화면 정보) --> context
        //context는 일반 클래스(화면에 안나오는 adapter)에서 바로 접근 X
        //
        //통신을 통해 액티비티 띄우게 하는 객체 --> intent
        //여기에서 디테일 띄우기



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_friend_profile, detail_clear;
        TextView tv_friend_name, tv_friend_msg;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_friend_profile = v.findViewById(R.id.imgv_friend_profile);
            detail_clear = v.findViewById(R.id.detail_clear);
            tv_friend_name = v.findViewById(R.id.tv_friend_name);

            tv_friend_msg = v.findViewById(R.id.tv_friend_msg);


        }
    }
}
