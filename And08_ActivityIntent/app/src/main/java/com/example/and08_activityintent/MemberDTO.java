package com.example.and08_activityintent;

import java.io.Serializable;

public class MemberDTO implements Serializable {
    private int a, b;
    private String c, d;
    
    //stream 흐름  통신에서 전송을 편하게 하기위해  메모리 변지수를 직렬로 바꾸는 것 
    //Main ==> Intent==> os ==> Intent ==>sub
    //직렬화 Serializable : 고유번호로 정리, 일렬로 나열한다, 하나의 흐름으로 묶는다 정리한다
    //Intent를 통해서 DTO 객체를 전송할때 반드시 직렬화를  해야 한다
    public MemberDTO(int a) {
        this.a = a;
    }

    public MemberDTO(int b, String c, String d) {
        this.b = b;
        this.c = c;
        this.d = d;
    }

    //alt+insert 또는 오마 generate// shift+ 방향키 선택


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
