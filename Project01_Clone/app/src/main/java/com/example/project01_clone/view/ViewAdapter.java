package com.example.project01_clone.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.KViewHolder> {
    LayoutInflater inflater;

    public ViewAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public KViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_view,parent,false);
        KViewHolder viewHolder = new KViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class KViewHolder extends RecyclerView.ViewHolder {

        public KViewHolder(@NonNull View v) {
            super(v);
        }
    }
}
