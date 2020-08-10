package com.company.day4;

/**
 * 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
 */

class Foo{
    int x;
    public void methodA(){

    }
}

class Bar extends Foo{
    int x;
    public void methodB(){

    }

}

public class Poly1 {
    public static void main(String[] args) {
        Bar bar = new Bar(); // 자식 객체 생성.
        Foo foo = (Foo)bar; // 부모 클래스 타입으로 형변환하여 자식 객체를 받음.
        // 부모 클래스 자료형이지만 객체를 생성하지는 않음. 힙영역에는 여전히 자식 객체가 있음.

        foo.methodA(); // 사용 가능
        //foo.methodB(); // 사용 불가능. 자식 클래스의 메소드는 사용할 수 없다. 문법적으로 사용할 수 없다.

        Foo foo1 = new Foo();
        //Bar bar1 = (Bar) foo1; // 문법 오류는 아니지만 자식클래스 타입으로 형변환하여 부모객체를 받는것 자체로 에러가 발생한다.
        // 자식 클래스 자료형으로 객체를 받으려 하지만, 부모 객체 부분만 있기 때문에 런타임 에러가 발생한다.
        //bar1.methodA(); // 문법 오류 x, 사용할 수 없다.
        //bar1.methodB(); // 문법 오류 x, 사용할 수 없다.

        // 여전히 힙영역에는 자식객체가 있음.
        Bar bar1 = (Bar) foo; // 자식 클래스 타입으로 자식 객체를 받음.
        bar1.methodA();
        bar1.methodB();
        bar1.x = 5;
        System.out.println(bar.x);
        System.out.println(foo.x);
        // bar1에서 변수 변경을 하면 bar에도 영향을 미친다. foo에는 영향 x
    }
}
