package com.company.day5;

import com.company.day1.Variable;

/**
 * 클래스에서 사용되는 변수(Variables)
 *  - 클래스 멤버 변수(static variable, class variable)
 *  - 인스턴스 멤버 변수(member variable, attribute, ...)
 *  - 로컬 변수(local variable)
 *  - 로컬 파라미터 변수(local parameter variable,arguments)
 */

public class Variable_Class {
    static int classVar; // 클래스 멤버 변수. 별도로 초기화 하지 않으면 0으로 자동으로 초기화.
    int instanceVar; // 인스턴스 멤버 변수. 별도로 초기화 하지 않으면 0으로 자동으로 초기화.
    
    public void method(int paramVar){ // 로컬 파라미터 변수
        System.out.println(paramVar); // 로컬 파라미터 변수 출력
        int localVar; // 로컬 변수
        //System.out.println(localVar); 로컬변수는 자동으로 초기화 되지 않기 때문에 초기화 하지 않은 상태에서는 출력 불가.
        localVar = 10;
        System.out.println(localVar); // 로컬 변수 출력
        {
            localVar = 10; // 상위 블록에서 선언 된 것은 하위 블록에서 변경 가능.
            int localVar2 = 20;
        }
        // localVar2 = 10; // 생명주기가 끝났으므로 접근 불가. 하위 블록에서 선언한 변수는 상위블록에서 사용할 수 없다.
    }
}

class VariableTest{
    public static void main(String[] args) {
        System.out.println("클래스 멤버 변수");
        System.out.println(Variable_Class.classVar); // 클래스 변수는 클래스 이름으로 바로 접근 가능
        Variable_Class.classVar = 5; // 클래스 이름으로 접근하여 값 변경도 가능
        System.out.println(Variable_Class.classVar);

        System.out.println("인스턴스 멤버 변수");
        Variable_Class vr = new Variable_Class();
        System.out.println(vr.instanceVar);
        // Variable_Class.instanceVar 클래스 이름으로는 접근 불가.
        vr.instanceVar = 20;
        System.out.println(vr.instanceVar);
        System.out.println(vr.classVar); // 클래스 변수는 객체에 할당되는 값이 아니기 때문에 가능하나 권장하지 않음.

        System.out.println("로컬 변수");
        vr.method(9);
    }
}