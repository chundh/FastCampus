package com.company.day4.Functinal_Interface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 람다식에 기존 메소드/ 생성자 사용
 * - 람다식에 기존에 구성되어 있는 내용을 재사용하고자 할 때
 */

public class class_InstanceMethod {
    public static void main(String[] args) {
        //클래스::인스턴스메소드
        String[] strings = {"sdf", "aser", "werwer" ,"fghj"};
        Arrays.sort(strings, String::compareTo);
        // o1.인스턴스메소드(o2)로 호출되는 메소드가 사용된다.
        // 메소드 실행간에 객체 두 개가 사용된다.

        // 클래스::클래스메소드
        Function<String, Integer> func = Integer::parseInt;
        Function<String, Integer> func1 = (x)->Integer.valueOf(x);


        // 인스턴스::인스턴스메소드
        String s = "aaa";
        Predicate<String> pre = s::equals;
        System.out.println(pre.test("aaa"));

        // 클래스::new
        UnaryOperator<String> oper = String::new;

        // 클래스[]::new -> 배열 생성
        IntFunction<String[]> fnc = String[]::new;
        String[] arr = fnc.apply(3);
        String[] arr1 = new String[3];


    }
}
