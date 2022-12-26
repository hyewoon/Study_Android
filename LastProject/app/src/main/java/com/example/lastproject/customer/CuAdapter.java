package com.example.lastproject.customer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.lastproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CuAdapter extends RecyclerView.Adapter<CuAdapter.CViewHOlder> {

    LayoutInflater inflater;
    ArrayList<CustomerVO> list;
    CustomerActivity activity; //activity는 인텐트로만

    public CuAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, CustomerActivity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_cu,parent,false);
        CViewHOlder viewHOlder = new CViewHOlder(v);
        return viewHOlder;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull CViewHOlder h, int i) {
        h.tv_id.setText(h.tv_id.getText() + " : " + list.get(i).getId());
        h.tv_name.setText(h.tv_name.getText() + " : " + list.get(i).getName());

        h.btn_delete.setOnClickListener(v -> {
            CheckDelete(list.get(i).getId());
        });

        h.btn_detail.setOnClickListener(v -> {
            //다이어로그 띄우기 customDialog
            Dialog dialog= new Dialog(activity);
            dialog.setContentView(R.layout.dialog_detail_cus);

            DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
            int device_witdh = metrics.widthPixels *50/100;
            int device_height = metrics.heightPixels *80/100;

            TextView tv_id = dialog.findViewById(R.id.tv_id);
            TextView tv_name = dialog.findViewById(R.id.tv_name);
            TextView tv_gender = dialog.findViewById(R.id.tv_gender);
            TextView tv_email = dialog.findViewById(R.id.tv_email);
            TextView tv_phone = dialog.findViewById(R.id.tv_phone);

            tv_id.setText(list.get(i).getId() + "");
            tv_email.setText(list.get(i).getEmail());
            tv_gender.setText(list.get(i).getGender());
            tv_name.setText(list.get(i).getName());
            tv_phone.setText(list.get(i).getPhone());


            dialog.show();//
          //  dialog.dismiss(); 안보이게
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CViewHOlder extends RecyclerView.ViewHolder {
        TextView tv_id , tv_name;
        Button btn_detail , btn_edit , btn_delete;
        public CViewHOlder(@NonNull View v) {
            super(v);
            tv_id = v.findViewById(R.id.tv_id);
            tv_name = v.findViewById(R.id.tv_name);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_edit = v.findViewById(R.id.btn_edit);
            btn_delete = v.findViewById(R.id.btn_delete);
        }
    }


    public void CheckDelete(int id){
        //네 누르면 삭제처리, 아니오를 누리면 아무런 처리 하지 않는다
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("고객정보 삭제").setMessage("정말로 삭제하시겠습니까?").setIcon(R.drawable.ic_launcher_background);

        builder.setPositiveButton("네",(dialog, which) -> {
            new CommonMethod().setParams("id",id).sendPost("delete.cu",(isResult, data) -> {
                Log.d("로그", "onBindViewHolder: " +data + "삭제");
                activity.selectList();
            });
        });

        builder.setNegativeButton("아니오",(dialog, which) -> {
            //아니오 누르면 실행됨
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
