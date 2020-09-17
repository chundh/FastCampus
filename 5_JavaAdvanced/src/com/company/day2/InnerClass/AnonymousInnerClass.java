package com.company.day2.InnerClass;

interface IFoo{
    void run();
}

class Foo implements IFoo{

    @Override
    public void run() {

    }

}

public class AnonymousInnerClass {
    static void useIFoo(IFoo iFoo){
        iFoo.run();
    }
    public static void main(String[] args) {
        Foo foo = new Foo();
        useIFoo(foo); // 다형성으로 인해서 사용 가능하다. foo->IFoo

        useIFoo(new IFoo(){
            @Override
            public void run() {

            }
        });
        // 구현해야하는 함수가 하나인 경우에만 사용할 수 있다.
        useIFoo(()-> {
            System.out.println("Lambda 식 사용");
        });
    }
}
