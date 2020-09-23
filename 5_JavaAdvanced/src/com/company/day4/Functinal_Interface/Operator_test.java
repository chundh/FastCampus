package com.company.day4.Functinal_Interface;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * Operator 계열
 * - 입력받은 타입과 동일한 타입의 출력을 하는 함수형 인터페이스
 * -
 */

public class Operator_test {
    public static void main(String[] args) {
        // 입력이 하나면 Unary를 붙여서 표현
        UnaryOperator<String> operator = s -> s+".";
        System.out.println(operator.apply("dkdk"));

        // 입력이 두개면 Binary를 붙여서 표현. 입력이 몇개던 출력은 P Type으로 고정이다.
        BinaryOperator<String> operatorTwo = (s1, s2) -> s1 + s2;
        System.out.println(operatorTwo.apply("s1" , "s2"));

        IntUnaryOperator op = value -> value*10;
        System.out.println(op.applyAsInt(5));

        IntBinaryOperator bop = (value1, value2) -> value1*value2;
        System.out.println(bop.applyAsInt(2, 3));
    }
}
