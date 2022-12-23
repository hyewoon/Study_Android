package com.example.and11_allview.myrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;
import com.example.and11_allview.gridv.GridApater;
import com.example.and11_allview.recycler.RecvAdapter;
import com.example.and11_allview.recycler.RecyclerFragment;

import java.util.ArrayList;

//2 두번째 내가 만든 viewHoler 찾아서 한다
public class MyRecvAdapter extends RecyclerView.Adapter<MyRecvAdapter.HeyViewHolder>{

 //3. 어댑터는 반드시 인플레이터 필요
  LayoutInflater inflater;
  ArrayList<MusicDTO>  list;

  //생성자

    public MyRecvAdapter(LayoutInflater inflater, ArrayList<MusicDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    public MyRecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //4 만든 뷰홀더를 리턴해주는 값
    @NonNull
    @Override
    public HeyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_my_recv, parent, false);
        HeyViewHolder viewHolder = new HeyViewHolder(v);

        return viewHolder;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    //데이터 연결
    @Override
    public void onBindViewHolder(@NonNull HeyViewHolder h, int i) {
        h.tv_rank.setText(list.get(i).getTv_rank());
        h.tv_album.setText(list.get(i).getTv_album());
        h.tv_singer.setText(list.get(i).getTv_singer());




    }
    //리턴값 지정
    @Override
    public int getItemCount() {
        return list.size();
    }

    //1. ViewHolder 상속받는 이너클래스 생성
    public class HeyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_rank, tv_album, tv_singer;
        ImageView imgv_my;
        public HeyViewHolder(@NonNull View v) {
            super(v);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_album= v.findViewById(R.id.tv_album);
            tv_singer = v.findViewById(R.id.tv_singer);




        }
    }




}
