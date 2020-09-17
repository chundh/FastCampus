package com.company.day2.InnerClass;

//클래스 영역이 아닌 로컬 영역에서 선언된 클래스이다.

public class LocalInnerClass {
    int x = 1;
    public void methodA(){
        class LocalInner{
            int x = 2;
//            static int z = 4 ->
//            불가능하다. static 변수는 class영역에 저장되어야하는데 LocalInner 클래스가 스택에 저장되므로 상충된다.
            static final int z = 4; // final은 더이상 수정이 되지 않는 상수풀에 영속적으로 존재하게 되므로 가능하다.
            void innerMethod(){
                System.out.println(x);
                System.out.println(this.x);
            }
        }
    }
}
