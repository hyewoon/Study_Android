package com.example.project01_clone.chat_exam;

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

//2. 리사이클러뷰는 반드시 뷰홀더를 강제하기 때문에 1번의 작업이 끝나고 나서 adapter 상속받는다
//extends Adapter

public class ChatExamAdapter extends RecyclerView.Adapter<ChatExamAdapter.HViewHolder> {
    //모양확인 (3. onCreateViewHolder, getItemCount 중복된 모양 디자인 확인 가능 )
    LayoutInflater inflater;
    ArrayList<ChatExamDTO> list;
    Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ChatExamAdapter(LayoutInflater inflater, ArrayList<ChatExamDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    //onCreateViewHolder오류 안나게 작성해보기
/*    public String m1(){
        return new String("test1");
    }

    public FriendDTO m2(){
        return new FriendDTO();
    }*/
    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //내가 return을 하고 싶으면 해당객체에 담을 수 있는 값 또는 해당하는 객체를 만들어서 return

        HViewHolder viewHolder = new HViewHolder(inflater.inflate(R.layout.item_recv_examchat,parent,false));
        return viewHolder;
     /*   return new HViewHolder(inflater.inflate(R.layout.item_recv_examchat,parent,false));*/
    }

    //binding. 어떤화면에 보이는 요소와 화면에 보이지 않는 데이터가 연결되었나
    //viewholder 와 Arraylist 연결됬나??
    @Override
    public void onBindViewHolder(@NonNull HViewHolder v, int i) {
        v.tv_chat_name.setText(list.get(i).getChat_name());
      v.tv_chat_msg.setText(list.get(i).getChat_msg());
      v.tv_chatdate.setText(list.get(i).getChat_date());
      v.ln_chat.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //화면 전환처리==> 채팅 액티비티
              Context con_temp = v.getContext();
              Intent intent = new Intent(context,ChatExamActivity.class);
              context.startActivity(intent);
          }
      });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //1.위젯들을 재활용을 위해서 묶어두기 위한 (메모리에 올려놓기 위한) 위젯용 DTO(ViewHolder)
    //dto : 여러가지 타입들묶어놓기 위한 것

    public class HViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_chat_profile;
        TextView tv_chat_name, tv_chat_msg, tv_chatdate;
        LinearLayout ln_chat;

        public HViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv_chat_profile= itemView.findViewById(R.id.imgv_chat_profile);
            tv_chat_name= itemView.findViewById(R.id.tv_chat_name);
            tv_chat_msg= itemView.findViewById(R.id.tv_chat_msg);
            tv_chatdate= itemView.findViewById(R.id.tv_chatdate);
            ln_chat= itemView.findViewById(R.id.ln_chat);





        }
    }

}
