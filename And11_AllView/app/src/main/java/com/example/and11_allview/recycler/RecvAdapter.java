package com.example.and11_allview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;
import com.example.and11_allview.gridv.GridApater;

//2. 밑에서 만든 뷰홀더이용해서 리사이클ㄹ뷰 상속받는다

public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.khwViewHolder> {
    //※layoutInflater 어댑터는 칸만 주지 붙이는 처리는 하지 않는다 --인플레이터가 붙이는 역할을 한다
    LayoutInflater inflater;

    public RecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    //3.우리가 만들어놓은 Viewholder를 실제로 만들고 return해주는 부분
    //4.viewHolder == 몇개의 위젯이 들어있는지 os가 판단 x, 우리가 커스텀해서 사용함
    //어떤 아이템에는 이미지뷰가 3개, 어떤 아이템에는텍스트 뷰가 3개로 다를 수 있음
    //BaseAdapter(getView 메소드)== 현 onCreateViewHolder
    //Viewgroup parent? 무엇인가 ? 어댑터가 주는 칸  10개 아이템

    @NonNull
    @Override
    public khwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_gridf_gridv, parent, false);
        khwViewHolder viewHolder = new khwViewHolder(v);

        return viewHolder;
    }

    //5. 데이터가 있다면 postion holder에 담겨져 있는 (칸) 위젯과 연결 부분(binding)
    @Override
    public void onBindViewHolder(@NonNull khwViewHolder h, int i) {
        h.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.imgv1.getVisibility() == View.VISIBLE){
                    h.imgv1.setVisibility(View.GONE);
                    h.imgv2.setVisibility(View.VISIBLE);

                }else {
                    h.imgv2.setVisibility(View.GONE);
                    h.imgv1.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    //overriding 하는 방법 : get + enter해서 찾는다
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    //4.아이템의 갯수를 지정하는 부분
    @Override
    public int getItemCount() {
        return 20;
    }

    //일반클래스 아닌 viewHolder타입이다
    //1.viewHolder타입을 상속받는 innerClass ViewHolder를 만든다
    //(이름 관레상 view holder)
    public class khwViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv1, imgv2 ;
        Button btn_change ;
        public khwViewHolder(@NonNull View v) {
            super(v);
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change = v.findViewById(R.id.btn_change);
            //위젯을 찾아온다


            //위젯들을 찾아서 초기화하는 기능을 했음
        }
    }

}
