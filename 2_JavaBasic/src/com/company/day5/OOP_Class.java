package com.company.day5;

/**
 * 클래스 : 객체를 생성하기 위한 설계도(Class)
 * 객체 : 클래스를 구체화하여 값으로 생성된 것(Object, Instance)
 * 클래스를 객체로 만드는 과정 -> Instanciation
 */

class Car{ // 클래스 이름은 보통 PascalCase로 적는다.
    int speed = 0; // 속성 or 멤버 변수
    // 속성: Attribute, Field
    // 멤버 변수: member variable

    public void move(){ // 메소드 (method)
        speed = 10; // 행위를 구현하며, 주로 속성을 변경한다.
    }
}


public class OOP_Class {
    public static void main(String args[]){
        Car car = new Car(); // new 키워드로 클래스에서 객체 생성
        System.out.println(car.speed); // .으로 속성 접근 가능
        car.move(); // 메소드 호출
        System.out.println(car.speed);

        Car car1 = new Car(); // 독립적인 새로운 객체 생성
        System.out.println(car1.speed); 

        Car car2 = car; // 참조형 객체. 새로운 객체를 만드는 것이 아니라 해당 값을 가리키기만 한다. car2->car
        System.out.println(car2.speed);
        car2.speed = 5; // 참조형 객체이기 때문에 car의 speed 값도 같이 바뀐다.
        System.out.println(car.speed);
    }
}
