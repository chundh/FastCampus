package com.company.day2.Interface;

/**
 * 인터페이스간의 상속
 * 인터페이스로 인턴페이스를 상속할 경우 extends를 사용한다.
 * 이 경우 extends를 사용해 다중상속을 할 수 있다.
 */

interface Walkable{
    void walk();
}

interface Runnable{
    void run();
}

interface Jumpable extends Walkable, Runnable{
    void jump();
}

class Jumper implements Jumpable{

    @Override
    public void walk() {
        System.out.println("walk");
    }

    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void jump() {
        System.out.println("jump");
    }
}
public class Interface2 {
}
