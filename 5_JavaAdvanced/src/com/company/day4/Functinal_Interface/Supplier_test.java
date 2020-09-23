package com.company.day4.Functinal_Interface;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Supplier 계열
 * - 아무런 입력을 받지 않고, 값을 하나 반환하는 함수형 인터페이스
 * - 자료를 '공급'하는 역할을 한다.
 */

public class Supplier_test {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "A String";
        System.out.println(supplier.get());

        // Supplier는 P Type 계열 메소드가 getAsP로 정의된다.
        BooleanSupplier boolSup = () -> true;
        System.out.println(boolSup.getAsBoolean());
        // IntSupplier, DoubleSupplier가 있다.

        IntSupplier rollDice = () -> (int)(Math.random()*6);
        for (int i = 0; i < 10; i++) {
            System.out.println(rollDice.getAsInt());
        }
    }
}
