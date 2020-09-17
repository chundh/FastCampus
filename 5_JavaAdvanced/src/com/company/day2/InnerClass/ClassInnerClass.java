package com.company.day2.InnerClass;

class outer2{
    static class ClassInner{
        int innerVar = 1;
        static int staticInnerVar = 100;
        void innerMethod(){
            // static 내부 클래스가 생성되는 시점에는 외부 객체가 존재하지 않는다.
            // 따라서 외부 변수에 접근하기 위해서는 외부 객체를 생성한 후 접근해야한다.
            outer2 outer = new outer2();
            System.out.println(outer.outerVar);
        }
    }
    private int outerVar = 2;
}

public class ClassInnerClass {
    public static void main(String[] args) {

    }
}
