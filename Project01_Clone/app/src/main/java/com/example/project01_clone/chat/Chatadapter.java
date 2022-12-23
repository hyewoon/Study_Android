package com.example.project01_clone.chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;
import com.example.project01_clone.friendlist.FriendAdapter;
import com.example.project01_clone.friendlist.FriendDTO;

import java.util.ArrayList;

//어댑터 상속받는다 --> 리사이클러뷰에 있는 어댑터 상속받는다.
public class Chatadapter extends RecyclerView.Adapter<Chatadapter.ViewHolder> {
//어댑터는 inflater 필요(inflater는 레이아웃(디자인을 붙이는역할, 생성자 만들기 ))
//inflater 리턴타입이 View , 그러므로 View 타입에 담을 수 있다
    LayoutInflater inflater;
    ArrayList<ChatDTO> list;
    Context context;

    public Chatadapter(LayoutInflater inflater, ArrayList <ChatDTO> list, Context context){

        this.inflater = inflater;
        this.list = list;
        this.context= context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = inflater.inflate(R.layout.item_recv_chat,parent,false);
       ViewHolder viewHolder = new ViewHolder(v);
       return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    //실제 데이터가 담긴 부분
    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_chat_profile.setImageResource(list.get(i).getImgRes());
        h.tv_chat_name.setText(list.get(i).getName());
        h.tv_chat_detail.setText(list.get(i).getMsg());
        h.tv_chat_time.setText(list.get(i).getTime());

        final int index = i;
        h.ln_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatActivity.class);
                ChatDTO dto =list.get(index);
                intent.putExtra("dto", dto);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //무엇을 상속받나?? 리사이클러뷰에 있는 뷰홀더
    //서로 다른 데이터를 담아야 한다-->
    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ln_chat;
        TextView tv_chat_name, tv_chat_detail,tv_chat_time;
        ImageView imgv_chat_profile;

        
        public ViewHolder(@NonNull View v) {
            super(v);
            ln_chat= v.findViewById(R.id.ln_chat);
            tv_chat_name= v.findViewById(R.id.tv_chat_name);
            tv_chat_detail= v.findViewById(R.id.tv_chat_detail);
            tv_chat_time= v.findViewById(R.id.tv_chat_time);
            imgv_chat_profile= v.findViewById(R.id.imgv_chat_profile);




        }
    }


}
