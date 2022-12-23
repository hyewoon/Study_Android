package com.example.project01_clone.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.project01_clone.R;

public class ChatActivity extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        intent =getIntent();
        /*ChatDTO dto = (ChatDTO) intent.getSerializableExtra("dto");*/

    }
}