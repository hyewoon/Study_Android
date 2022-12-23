package com.example.and11_allview.gridv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.and11_allview.R;

public class GridApater extends BaseAdapter {
    
    //반드시 인플레이터 필요
    //붙이는 처리--> convertView
    
    LayoutInflater inflater;
    
    public GridApater(LayoutInflater inflater){
        this.inflater = inflater;
    }
    
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    int count = 0;
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(v == null){
            v = inflater.inflate(R.layout.item_gridf_gridv, parent,false);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
            count++;
        }else{
            if(v.getTag() != null){
                viewHolder = (ViewHolder) v.getTag();
            }

        }

        final ViewHolder tempViewHodler = viewHolder;
        viewHolder.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //index == 0 (Imageview1, Imageview2, button)
                if(tempViewHodler.imgv1.getVisibility() == View.VISIBLE){
                    tempViewHodler.imgv1.setVisibility(View.GONE);
                    tempViewHodler.imgv2.setVisibility(View.VISIBLE);

                }else {
                    tempViewHodler.imgv2.setVisibility(View.GONE);
                    tempViewHodler.imgv1.setVisibility(View.VISIBLE);

                }
            }
        });
        //붙이고 , 위젯을찾는다. 
       /* convertView = inflater.inflate(R.layout.item_gridf_gridv, parent, false);
        ImageView imgv1 = convertView.findViewById(R.id.imgv1);
        ImageView imgv2 = convertView.findViewById(R.id.imgv2);
        Button btn_change = convertView.findViewById(R.id.btn_change);*/


        Log.d("로그", "getView: "+ count);

        return v;
    }
    
    //매번 getView통해서 붙이고 위젯 찾는 과정 --> 단순화 : recycle(재활용)
    //한번 붙여놓은 아이템을 메모리에 저장해놨다가 다시 사용하는 구조로 만들자!==> recycleView
    //한번 붙여놓고 나서 다시 계속 새로 붙이는 처리
    //※ 위젯을 묶어놓은 DTO ===> ViewHolder(inner 클래스로 많이 사용) ※
    //리상클러 뷰는 뷰홀더라는 클래스를 강제한다(무조건 만들어야 함)

    public class ViewHolder{
        //필드: 위젯들을 전부 다 써줌.
        ImageView imgv1, imgv2;
        Button btn_change ;

        public ViewHolder(View v){
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change= v.findViewById(R.id. btn_change);

        }

    }
}
