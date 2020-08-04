package com.company.day2;

/**
 * Getter, Setter
 * 멤버 변수를 간접적으로 다룰 수 있게 해 주는 메소드
 * 멤버 변수의 캡슐화(Encapsulation)에 도움이 됨
 *         -> 정보의 은닉/보호
 * 멤버 변수의 값을 제한해야 할 때 유용
 */

class test{
    int x;
    int y;
    String z;
    float w;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x>0 && x<=1000) // 원하는 특정 범위의 값이 있을 때 조건을 통해 강제할 수 있다.
            this.x = x;
        else
            System.out.println("x should be 1<= x <= 1000");
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}

public class Getter_Setter_Class {
    public static void main(String[] args) {
        test t = new test();

        t.x = 20; // 권장되지 않는 방법이다. Getter와 Setter를 통해 접근하자.
                  // 멤버 변수를 private으로 설정한다면 이와 같은 방법으로 접근이 불가능하다.

        t.setX(10);
        System.out.println(t.getX());
    }
}
