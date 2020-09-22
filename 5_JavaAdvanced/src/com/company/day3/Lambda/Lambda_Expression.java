package com.company.day3.Lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 람다식 (Lambda Expression)
 * - JDK 1.8에서 추가된 함수형 프로그래밍 기법
 * - 함수형 프로그래밍 -> 객체지향 프로그래밍과 다르게, 비즈니스 로직만 빠르게 구현하는 방식
 * 비즈니스 로직 = Mission Critical -> 돈이 되는 부분. 실질적으로 기능이 수행되는 부분
 * - 객체지향 언어인 Java에서 메소드를 함수처럼 사용하는 방식
 *
 */


public class Lambda_Expression {
    public static void main(String[] args) {
        // 람다식의 대표적인 사용 예
        // 배열의 정렬
        String[] strings = {"front", "backend", "Android", "Java"};
        System.out.println(Arrays.toString(strings));

        // 방법 1. Comparator 클래스를 만들고 객체를 생성하여 전달
        class MyComparator implements Comparator<String>{

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }
        Arrays.sort(strings, new MyComparator());
        System.out.println(Arrays.toString(strings));

        // 방법 2. 익명 내부 클래스를 이용
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        // 방법 3. 람다식을 이용. 실제로 동작하는 부분만 심플하게 표현.
        Arrays.sort(strings, (o1, o2) -> 0);
    }
}
