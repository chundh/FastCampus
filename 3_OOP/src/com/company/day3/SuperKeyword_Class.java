package com.company.day3;

/**
 * super 키워드
 * - this가 자기 자신의 객체를 참조하듯, super는 부모 객체를 참조한다.
 * - super.super로 부모의 부모는 참조할 수 없다. 바로 위 부모만 가능하다.
 */

class Foo{
    String x = "Foo";

    public Foo(String x) {
        this.x = x;
    }
}

class Bar extends Foo{
    String x = "Bar"; // 자식 클래스의 변수 명이 부모 클래스의 변수 명과 겹치면 자식 클래스에서 다시 정의하게된다.
                      // 이때 부모 클래스의 변수가 사라지는 것이 아니다. 자식 클래스의 변수에 우선접근하게 된다.
                      // 로컬 멤버 변수 -> 자식 클래스 변수 -> 부모 클래스 변수 순으로 접근하게 된다.

    // 자식 클래스에서 생성자를 만들어 줄 때 부모 클래스의 생성자도 같이 호출해야 한다.
    // 단, 부모클래스가 기본 생성자를 사용하는 경우는 호출하지 않아도 된다.
    public Bar(String x, String x1) {
        super(x); // 무조건 첫줄에 와야한다. 부모 객체를 먼저 생성하고, 자식 객체를 생성.
        this.x = x1;
    }

    public void method(){
        String x = "method";
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
    }
}
public class SuperKeyword_Class {
    public static void main(String[] args) {
        Bar b = new Bar("foo", "bar");
        b.method();
    }
}
