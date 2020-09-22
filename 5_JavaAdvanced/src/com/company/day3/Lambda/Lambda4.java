package com.company.day3.Lambda;

@FunctionalInterface
interface IFoo{
    String method();
}

public class Lambda4 {
    static void functionalMethod(IFoo ifoo){
        System.out.println(ifoo.method());
    }

    void methodA(){ // 람다식과 익명클래스에서의 this 객체가 동일하지 않음을 보여준다.
        functionalMethod(()->{
            // this가 lambda4의 this이다.
            // 실제로 객체가 생성되지 않는다.
            System.out.println("this : " + this);
            System.out.println("OuterClass this : " + Lambda4.this);
            return "Lambda expression used";
        });

        functionalMethod(new IFoo() { // 익명클래스가 만들어지고, 그 객체가 만들어지는 과정
            @Override
            public String method() {
                System.out.println("this : " + this); // 익명클래스의 객체가 this가된다.
                System.out.println("OuterClass this : " + Lambda4.this);
                return "Anonymous local inner class used";
            }
        });
    }

    public static void main(String[] args) {
        new Lambda4().methodA();
    }
}
