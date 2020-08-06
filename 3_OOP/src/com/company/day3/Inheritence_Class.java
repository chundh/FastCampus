package com.company.day3;

import com.sun.security.jgss.GSSUtil;

/**
 * 상속(Inheritence)
 * - 어떤 클래스의 모든 멤버 변수 및 메소드를 계승하여 새로운 클래스를 생성하는 것
 * 
 * 상속 대상 : 조상클래스, 부모클래스, 상위클래스, 슈퍼클래스 등의 이름으로 불림
 * 상속 결과 : 자손클래스, 자식클래스, 하위클래스, 서브클래스 등의 이름으로 불림
 *
 * 상속 관계를 흔히 'IS-A' 관계라고 부른다.
 *
 */

class Person{
    String name;

    public void work(){
        System.out.println("일하기");
    }

    public void sleep(){
        System.out.println("잠자기");
    }
}
//person을 상속하는 자식클래스
class Developer extends Person{
    String mainLang;

    public void writeCode(){
        System.out.println("코딩하기");
    }
    @Override
    public void work() {
        System.out.println("dev 일하기");
    }
}

class student extends Person{
    String major;
    public void writeCode(){
        System.out.println("밤새 코딩하기");
    }
}

public class Inheritence_Class {
    public static void main(String[] args) {
        //클래스를 상속하면, 모든 멤버 변수와 메소드를 상속받는다.
        Developer dev = new Developer(); // Developer객체이지만 Person의 기능도 모두 수행 가능하다.
        dev.name = "dev";                // Developer 'IS-A" person
        System.out.println(dev.name);
        dev.work();
        dev.sleep();

        dev.mainLang = "Java";
        dev.writeCode();
        student st = new student();
        st.writeCode();
    }
}
