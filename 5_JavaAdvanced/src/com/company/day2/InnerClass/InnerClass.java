package com.company.day2.InnerClass;

class outer{
    class InstanceInner{
        int innerMemverVar = 1;
        static final int CONSTANT_VAR = 1000; // static 변수는 final만 가능하다.

        void innerMethod(){
            System.out.println(innerMemverVar);
            System.out.println(outerMemberVar);
        }
    }
    private int outerMemberVar = 2;

    void outerMethod(){
        InstanceInner obj = new InstanceInner();
        obj.innerMethod();
    }
    // static 메소드의 경우 outer클래스의 객체가 없어도 실행이 된다.
    // InnerClass는 outer클래스의 객체가 있어야 접근이 가능하다.
    public static void methodA(){
        outer outer = new outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }
}



public class InnerClass {
    public static void main(String[] args) {

    }
}
