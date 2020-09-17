package com.company.day2.InnerClass;

class outer1{
    class InstanceInner{
        int x = 1;
        static final int CONSTANT_VAR = 1000; // static 변수는 final만 가능하다.
        void innerMethod(){
            int x = 0;
            System.out.println(x); //0
            System.out.println(this.x); //1
            System.out.println(outer1.this.x); //2
            System.out.println(outer1.y); //3
        }
    }
    private int x = 2;
    private static int y = 3;

}

public class InnerClass2 {
}
