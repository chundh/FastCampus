package com.company.day4.Functinal_Interface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * Function 계열
 * - Mapping: 입력 -> 출력의 Mapping을 하는 함수형 인터페이스
 * - 입력 타입과 출력 타입은 다를 수 있다.
 */

public class Function_test {
    public static void main(String[] args) {
        Function<String, Integer> func = (s) -> s.length(); // 첫번째 파라미터가 입력 타입, 두번째 파라미터가 출력 타입
        System.out.println(func.apply("Four"));

        BiFunction<String, String, Integer> funcTwo = (s, u) -> s.length() + u.length();
        System.out.println(funcTwo.apply("sdf", "sdfw"));

        // P Type Function은 입력을 P Type으로 받는다.
        IntFunction<String> funcTree = value -> ""+value;
        System.out.println(funcTree.apply(3212));

        // ToP Type Function은 출력을 P타입으로 한다.
        ToIntFunction<String> funcFour = (s)->s.length();
        System.out.println(funcFour.applyAsInt("ABCDE"));
    }
}
