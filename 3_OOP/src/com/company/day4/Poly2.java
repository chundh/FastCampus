package com.company.day4;

/**
 * 멤버 변수의 재정의는 선언된 객체의 타입을 따른다. (문법적으로 본다)
 * 메소드 오버라이딩은 메모리상의 객체 타입을 따른다. (실제 객체로 본다)
 *
 * 가상 메소드 호출 : Virtual method call
 * -> 실제로 호출이 되지는 않는 메소드 이지만 문법을 맞추기 위해 구현되어있는 메소드
 */

class Foo1{
    public String x = "Super";

    public void MethodA(){
        System.out.println("Super Method");
    }
}

class Bar1 extends Foo1{
    public String x = "Sub";

    @Override
    public void MethodA(){
        System.out.println("Sub");
    }
}

public class Poly2 {
    public static void main(String[] args) {
        Bar1 bar1 = new Bar1();
        Foo1 foo1 = (Foo1) bar1;

        System.out.println(bar1.x); // Sub
        bar1.MethodA(); // Sub

        System.out.println(foo1.x); // Super
        foo1.MethodA(); // Sub

        bar1.x = "dd";
        System.out.println(bar1.x);
        System.out.println(foo1.x);

        Bar1 bar2 = bar1;
        bar2.x = "dfd";
        System.out.println(bar1.x);
        System.out.println(foo1.x);
    }
}
