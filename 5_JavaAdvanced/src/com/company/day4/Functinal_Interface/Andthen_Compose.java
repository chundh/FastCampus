package com.company.day4.Functinal_Interface;

import java.util.function.*;

/**
 * andThen 메소드, compose 메소드
 * - Consumer(andThen만 존재), Function, Operator 계열의 default method로 구현되어있다.
 * - andThen 메소드 : A.andThen(B) -> A부터 실행하고 B를 실행
 * - compose 메소드 : A.compose(B) -> B부터 실행하고 A를 실행
 */


public class Andthen_Compose {
    public static void main(String[] args) {
        Consumer<String> c0 = s -> System.out.println("c0: " + s);
        Consumer<String> c1 = s -> System.out.println("c1: " + s);
        Consumer<String> c2 = c0.andThen(c1);
        c2.accept("String");

        // Function 계열은 입력->출력 => 입력->출력 타입이 연쇄적으로 이루어져야 한다.
        Function<String, Integer> func1 = s -> s.length();
        Function<Integer, Long> func2 = value -> Long.valueOf(value);
        Function<String, Long> func3 = func1.andThen(func2); // func1의 출력이 Integer이므로 andThen에는 Integer를 입력으로 받을 수 있어야 한다.
        System.out.println(func3.apply("aaa"));

        Function<String, Long> func4 = func2.compose(func1);
        System.out.println(func4.apply("aaa"));

        BinaryOperator<String> op0 = (s1, s2) -> s1 + s2;
        UnaryOperator<String> op1 = (s) -> s + ".";// op0의 출력이 String이므로 op1의 입력 타입은 String이여야 한다.
        BiFunction<String, String, String> op2 = op0.andThen(op1); // operator를 섞어 쓰더라도 중간에 function계열이 섞여 있을 수 있기 때문에 최종 결과는 Function이 되어야 한다.
        System.out.println(op2.apply("a", "b" ));
    }
}
