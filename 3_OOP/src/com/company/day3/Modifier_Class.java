package com.company.day3;

class A{
    public int x; // 모두 접근 가능
    protected int y; // 다른 패키지여도 자식이면 접근 가능. 같은 패키지에 속한 클래스는 접근 가능.
    // -> private처럼 쓰지만 상속한 클래스의 접근이 필요할 때 사용한다.
    int z; // Default 타입. 같은 패키지에 속한 클래스에서만 접근 가능.
    private int w; // 클래스 외부에서는 접근이 불가능하므로 주로 클래스 내부 구성을 할 때 사용한다.

    public void methodA(){}
    protected void methodB(){}
    void methodC(){}
    private void methodD(){}

    public void methodTest(){
        System.out.println(); // xyzw, method 4개 모두 접근 가능하다.
    }
}

public class Modifier_Class {
    public static void main(String[] args) {
        A a = new A(); // 같은 패키지 안에 있는 클래스에서 객체 접근 실험.
        System.out.println(a.x); // private인 w와 methodD빼고 모두 접근 가능하다.
    }
}
