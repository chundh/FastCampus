package com.company.day2.Interface;

/**
 * 인터페이스(Interface)
 * - 클래스가 사용하는 방식/접점만을 선언하는 클래스와 유사한 툴
 * - 아무런 구현이 되어있지 않으며, 모든 메소드가 추상 메소드이다.
 *
 * 특징
 * - 클래스가 아니고 인터페이스라는 키워드를 사용한다.
 * - 인터페이스는 객체를 만들 수 없다.(추상 클래스가 존재하기 떄문에)
 * - 멤버 변수는 항상 "public static final"이고 생략 가능하다. -> public static final을 안써도 public static final이다.
 * - 멤버 메소드는 항상 "public abstract"이고 생략 가능하다. -> //
 * - 클래스는 하나만 상속할 수 있으나, 인터페이스는 여러개 가능하다.
 * - 인터페이스에 상속은 implements 키워드를 사용한다.
 */

// 제어자로 public, default 가능하다.
interface IFoo{
    int x = 0;
    public static final int MEMBER_VAR = 10;
    int MEMBER_VAR2 = 20; // public static final

    public abstract void methodA(int param);
    void methodB(int param); // public abstract
}

class Foo implements IFoo{

    @Override
    public void methodA(int param) {
        System.out.println(param);
    }

    @Override
    public void methodB(int param) {
        System.out.println(param);
    }
}

public class Interface {
    public static void main(String[] args) {
        Foo f = new Foo();
        System.out.println(f.x);
        System.out.println(IFoo.x);
    }
}
