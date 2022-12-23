package com.example.project01_clone.friendlist;

import android.content.Context;

import java.io.Serializable;

public class FriendDTO implements Serializable {
    private int imgRes;
    private String name, msg;
    Context context;

    public FriendDTO(int imgRes, String name, String msg) {
        this.imgRes = imgRes;
        this.name = name;
        this.msg = msg;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
