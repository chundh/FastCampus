package com.company.day5.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API
 * JAVA 8에 추가된 java.util.stream 패키지
 * 컬렉션 요소를 람다식으로 처리할수 있도록 돕는 함수형 프로그래밍 도구
 * - 간결한 코드로 작성할 수 있다.
 * - 데이터 소스에 대한 공통된 접근 방식
 *   -
 */

public class streamapi {
    public static void main(String[] args) {
        // JAVA 7이전 버전
        List<String> list = Arrays.asList("fast", "campus", "rocks");
        for (String s : list) {
            System.out.println(s.toUpperCase());
        }

        // JAVA8 Stream API 사용 버전
        List<String> list1 = Arrays.asList("fast", "campus", "rocks");
        Stream<String> stream = list1.stream();
        stream.map(String::toUpperCase) // uppercase로 매핑하고, 하나씩 출력한다.
                .forEach(System.out::println);

        Stream<String> stream1 = list1.stream();

        int[] ints = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(ints);
        IntPredicate pre = value -> value > 0;
        System.out.println(intStream.allMatch(pre));
        //LongStream, DoubleStream등도 있다. Stream<Integer>를 썼을때와 비교하면 오토/언박싱의 과정이 발생하지 않아 더 효율적이다.

        // Stream 클래스의 클래스 메소드 of로 바로 생성할 수 있다.
        DoubleStream doubleStream = DoubleStream.of(0.4, 0.5, 0.1, 0.9);

        // 실제 사용 방법
        Stream<String> stringStream = Stream.of("Java", "Is", "Fun", "Isn't", "It", "?");
        stringStream.peek(System.out::println);
        // 중간처리 메소드 - 스트림을 반환 (stringStream.distinct()가 스트림을 반환한다.)
        // 필터링 메소드
        // distinct() : 스트림에 같은 요소가 있는 경우 하나만 남기고 다 삭제한다.
        stringStream.distinct().forEach(System.out::println);
        // filter() : Predicate 계열을 입력으로 받아, true인 요소만 남긴다.
        //stringStream.filter(s -> s.length() >= 3).forEach(System.out::println);

        // 자르기
        // skip(long n) : 스트림의 최초 n개를 생략하는 메소드
        // limit(long maxSize) : 스트림의 최대 요소 개수를 maxSize로 제한

        // 정렬
        // 같은 기능을 수행하는 두 코드
        stringStream = Stream.of("Java", "Is", "Fun", "Isn't", "It", "?", "assfsg");
        stringStream.sorted().forEach(System.out::println);
        stringStream = Stream.of("Java", "Is", "Fun", "Isn't", "It", "?ass", "assfsg");
        stringStream.sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);

        // 매핑
        // Function 계열의 인터페이스를 사용하여 스트림의 각 요소를 매핑
        stringStream = Stream.of("abs", "werghh", "werj", "qwgqqqqqu");
        // String->Integer로 변환하는 매핑 (Function<String, Integer>)
        Stream<Integer> stream2 = stringStream.map(s -> s.length());
        stream2.forEach(System.out::println);
        // PStream (기본형 타입의 스트림)
        IntStream intStream1 = IntStream.of(1,3,45,57,24,5,8,2);
        IntStream intStream2 = intStream1.map(value -> value * 10);
        intStream2.forEach(System.out::println);
        // flatMap 계열 매핑 입력1 : n출력 (스트림 형태로 출력)
        List<String> list2 = Arrays.asList("java" , "sdfsfd" ,"1234sdf", "asd");
        list2.stream().flatMap(s ->{
            return Arrays.stream(s.split(""));
        }).forEach(System.out::println);

        // 조회 (Peek) : 중간 결과를 출력해볼 수 있음(디버깅시 유용)
        // peek() : Consumer 계열을 입력으로 받아 입력 요소를 소비
        list2.stream().flatMap(s ->{
            return Arrays.stream(s.split(""));
        }).peek(s -> System.out.println("flatMap : " + s));
    }
}
