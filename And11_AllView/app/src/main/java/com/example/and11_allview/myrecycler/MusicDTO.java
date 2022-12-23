package com.example.and11_allview.myrecycler;

public class MusicDTO {
    String  tv_rank, tv_album, tv_singer;

    public MusicDTO(String tv_rank, String tv_album, String tv_singer) {
        this.tv_rank = tv_rank;
        this.tv_album = tv_album;
        this.tv_singer = tv_singer;
    }

    public String getTv_rank() {
        return tv_rank;
    }

    public void setTv_rank(String tv_rank) {
        this.tv_rank = tv_rank;
    }

    public String getTv_album() {
        return tv_album;
    }

    public void setTv_album(String tv_album) {
        this.tv_album = tv_album;
    }

    public String getTv_singer() {
        return tv_singer;
    }

    public void setTv_singer(String tv_singer) {
        this.tv_singer = tv_singer;
    }
}
