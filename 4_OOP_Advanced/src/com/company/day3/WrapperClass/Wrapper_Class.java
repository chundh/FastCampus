package com.company.day3.WrapperClass;

/**
 * Wrapper 클래스 (Wrapper Class)
 * - 기본형 타입을 객체로 쓰기 위해 있는 클래스
 * - 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공
 *
 * - 객체로 사용될 필요가 있을 떄는 Autoboxing이 이루어지고
 * - primitive 타입으로 사용될 필요가 있을 때는 Unboxing이 이루어진다.
 * byte -> BYTE
 * char -> Character
 * short -> Short
 * double -> Double
 */

public class Wrapper_Class {
    // x,y 를 받으면 자동으로 Integer 객체로 Autoboxing해서 계산한다.
    public static Integer add(Integer x, Integer y){
        return x + y;
        // 자동으로 기본자료형으로 변형되어서 계산
        // 변환 시에는 다시 Integer로 Autoboxing이 이루어짐
    }

    public static <T> T byPass(T x){ // T에는 원래 Primitive 타입은 올 수가 없다(int, double 등등)
                                     // 하지만 Wrapper Class를 사용해서 primitive 타입을 객체 타입으로 Autoboxing하여 사용할 수 있다.
        return x;
    }

    public static void main(String[] args) {
        Integer integer = new Integer(10); // 10이라는 primitive type을 자동으로 Integer타입의 객체로 autoboxing
        Integer integer1 = Integer.valueOf(10);

        Character character = new Character('@');
        Character character1 = Character.valueOf('f');

        //AutoBoxing
        Integer integer2 = 4; // primitive 4를 Integer 객체로 자동 autuboxing
        System.out.println(add(4,2));

        byPass(5); // autoboxing이 이루어진다
        // T: Wrapper Class인 Integer로 결정됨
        // 5 -> new Integer(5) 로 autoboxing이 된다.

        // 문자열 <-> 기본 자료형
        int x = Integer.parseInt("100");
        int y = new Integer("100"); // String을 입력받으면 오버로드 된 메소드를 호출하고,
        // Integer 객체로 autoboxing 후 primitive 타입으로 autoboxing해준다.
    }
}
