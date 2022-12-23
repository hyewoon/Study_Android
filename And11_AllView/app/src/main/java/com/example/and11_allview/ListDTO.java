package com.example.and11_allview;

public class ListDTO {
    private String name, cnt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public ListDTO(String name, String cnt) {
        this.name = name;
        this.cnt = cnt;


    }
}
