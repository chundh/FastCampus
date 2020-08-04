package com.company.day2;

/**
 * 초기화 블록(Initializer)
 * 기본적으로 static, instance의 초기화 값을 설정할 수 있다.
 * static initializer는 class가 호출되면 바로 접근한다.
 * instance initializer는 객체가 생성될 때 접근한다.
 * 하나의 class에 여러개 존재 할 수 있다. 여러개 존재한다면 위에서 아래의 순서로 접근한다.
 */

class Initializer{
    static int classVar;
    static int instanceCount;
    int instanceVar;

    // static initializer. 객체가 생성되기 전 접근한다. 따라서 instance 변수에는 접근할 수 없다.
    static {
        System.out.println("static block1");
        classVar = 20;
    }
    // instance initializer. 객체가 생성될 때 접근한다. instance 변수, static 변수 모두 접근할 수 있다.
    {
        System.out.println("block1");
        instanceVar = 30;
        classVar = 50; // 권장하지 않는 방법
        instanceCount++;// 예외적으로 instance의 갯수 등의 특정 값을 유지해야 할 때 static 변수 접근하는 것을 활용한다.
    }
}

public class Initializer_Class {
    public static void main(String[] args) {
        System.out.println(Initializer.classVar);
        Initializer initializer = new Initializer();
        System.out.println(initializer.instanceVar);
        System.out.println(Initializer.classVar);
    }
}
