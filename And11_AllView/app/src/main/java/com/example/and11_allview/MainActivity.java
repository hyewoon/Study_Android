package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.and11_allview.gridv.GridFragment;
import com.example.and11_allview.listfrag.ListFragment;
import com.example.and11_allview.myrecycler.MyRecvFragment;
import com.example.and11_allview.recycler.RecyclerFragment;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

     Button btn_sub, btn_grid, btn_recycle, btn_list, btn_recycle_my, btn_recyle_team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub = findViewById(R.id.btn_sub);
        btn_grid = findViewById(R.id.btn_grid);
        btn_list = findViewById(R.id.btn_list);
        btn_recycle = findViewById(R.id.btn_recycle);
        btn_recycle_my = findViewById(R.id.btn_recycle_my);
        btn_recyle_team = findViewById(R.id.btn_recyle_team);






        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
            }
        });


        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, SubActivity.class);

                 startActivity(intent);

            }
        });
        //grid
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new GridFragment()).commit();
            }
        });
        btn_recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecyclerFragment()).commit();

            }
        });

        btn_recycle_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyRecvFragment()).commit();
            }
        });

        btn_recyle_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyRecvFragment()).commit();
            }
        });

    }
}