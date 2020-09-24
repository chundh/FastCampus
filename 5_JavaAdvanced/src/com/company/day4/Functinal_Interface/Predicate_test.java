package com.company.day4.Functinal_Interface;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/**
 * Predicate 계열
 * - 논리 판단을 해주는 함수형 인터페이스
 * - 입력을 받아서 boolean 타입 출력으로 변환
 */

public class Predicate_test {
    public static void main(String[] args) {
        Predicate<String> pred = (x) -> x.length()==4;
        System.out.println(pred.test("absd"));

        BiPredicate<String, Integer> pred2 = (s, v) -> s.length()==v;
        System.out.println(pred2.test("sdf", 3));

        DoublePredicate pred0 = value -> value>0.5;
        DoublePredicate pred1 = value -> value<1.2;
        DoublePredicate pred3 = pred0.and(pred1).negate().or(pred0.negate());
        System.out.println(pred0.negate());

        System.out.println(pred3.test(0.8));

    }
}
