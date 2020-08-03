package com.company.day5;

/**
 * 문자열
 * 문자들은 내부적으로 '클래스'로 구성되어있다.
 * 내부에는 문자의 배열로 된 데이터가 있다. char[]
 * 한번 만든 문자열은 변하지 않는다.
 * 문자열 편집은 String을 쓰지 않고 Builder나 Buffer를 사용한다.
 */

public class Strings_Class {
    public static void main(String args[]){

        //문자열의 생성
        String s1 = "문자열 생성 방법"; // 문자열을 곧바로 생성할 경우 상수 풀에서 찾아서 사용
        String s2 = new String("문자열 생성 방법"); // 문자열을 클래스로 생성할 경우 새로운 값을 생성

        System.out.println(s1 == s2); // false
        // 메모리 참조 값이 다르기 때문에 밑의 방식으로 해야 정상적으로 String값 계산을 할 수 있다.
        System.out.println(s1.equals(s2)); // true

        s1.indexOf("a"); // 해당 문자의 index값 return
        s1.equalsIgnoreCase("대소문자 구분하지 않고 계산할 문장"); // 대소문자를 구분하지 않고 계산
        s1.replace("l", "t"); // 기존의 string을 바꾸는 것이 아니라, string을 새로 생성해서 출력
        s1.substring(0,s1.length()); // 0~s1의 길이-1 까지의 문자열을 출력
        s1.trim(); // 문자열의 공백을 제거한 문자열을 출력

    }
}
