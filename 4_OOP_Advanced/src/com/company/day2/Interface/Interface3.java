package com.company.day2.Interface;

import java.io.FileWriter;

/**
 * JDK 1.8이후의 인터페이스
 *
 * 인터페이스에는 default 메소드를 구현할 수 있음.
 * default 메소드는 항상 public이다.
 * 인터페이스의 철학과 맞지 않으나, 기존에 사용하던 인터페이스가 개선되어,
 * 모든 자식 메소드에 동일하게 구현되어야 하는 메소드가 생긴 경우에 쉽게 기능을 추가하기 위해 만들어짐.
 */
interface IFooTwo{
    void abstractMethod();
    default void defaultMethod(){ // 디폴트 메소드
        System.out.println("Default Method");
    }
}
class FooTwo implements IFooTwo{
    @Override
    public void abstractMethod() {
        System.out.println("Abstract method implement");
    }
    // 디폴트 메소드는 오버라이드 해도 되고, 안하고 그냥 사용할 수도 있다.
    @Override
    public void defaultMethod() {
        System.out.println("Overriden default method");
    }
}
class SuperFoo{
    public void defaultMethod(){
        System.out.println("default method in superfoo");
    }
}
class FooThree extends SuperFoo implements IFooTwo{
    @Override
    public void abstractMethod() {
        System.out.println("Abstract method in FooThree");
    }
}
// 인터페이스의 static 메소드
interface IBar{
    static void staticMethod(){
        System.out.println("static method");
    }
}
class Bar implements IBar{

}
public class Interface3 {
    public static void main(String[] args) {
        FooTwo fooTwo = new FooTwo();
        fooTwo.abstractMethod();
        fooTwo.defaultMethod();

        FooThree fooThree = new FooThree();                         
        fooThree.abstractMethod();
        fooThree.defaultMethod(); // 부모와 인터페이스에 모두 메소드가 있는 경우 부모 클래스에 있는 메소드를 실행한다.
        // 다중 상속시의 문제를 방지하기 위해, 인터페이스보다 일반 상속이 우선시된다.

        IBar.staticMethod(); // static 메소드는 인터페이스명으로 바로 호출 가능하다.
        //Bar.staticMethod(); // 구현체인 자식클래스는 클래스 메소드를 호출할 수 없다.
    }
}
