package com.company.day4.Functinal_Interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/**
 * Consumer 계열
 * - 파라미터 입력을 받아서 그것을 소비하는 Functinal Interface
 * - accept 메소드를 사용하고 return이 없다.(void)
 */

public class Consumer_test {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("A String");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + " , " + u);
        biConsumer.accept("String A", "String B");

        // 오토박싱/언박싱 사용 - 비효율적
        Consumer<Integer> integerConsumer = (x) -> System.out.println(x);
        integerConsumer.accept(5);

        // 기본형 입력을 하려고 할 경우, PConsumer (P:Primitive Type)을 사용할 수 있다.
        IntConsumer intConsumer = (x) -> System.out.println(x);
        intConsumer.accept(10);
        // LongConsumer, DoubleConsumer 등이 있다.
        // 오버로딩이 아니라 별도로 만들어준 것이다.

        ObjIntConsumer<String> objIntConsumer = (t, x) -> System.out.println(t + " , " +x);
        objIntConsumer.accept("x", 1023);
    }
}
