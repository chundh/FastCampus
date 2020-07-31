package com.company.day1;


/**
 * 자료형(DataTypes)
 * 자료형 - 기본형(Primitive Type), 참조형(Reference Type)
 * 기본형 - 정수형, 실수형, 문자형, 논리형
 * 참조형 - 문자열(String)
 */

public class DataTypes {
    public static void main(String args[]){
        System.out.println("Byte");
        System.out.println(Byte.BYTES);

        //BYTE : 1byte로 구성
        System.out.println(Byte.MAX_VALUE); // 0을 표현하기 위해 2^7 -1
        System.out.println(Byte.MIN_VALUE); // -2^7
        //BYTE의 데이터 범위는 -128~127

        //SHORT : 2byte로 구성
        System.out.println(Short.MAX_VALUE); // 2^15-1
        System.out.println(Short.MIN_VALUE); // -2^15
        //SHORT의 데이터 범위는 -32768~32767

        //INTEGER : 4byte로 구성
        System.out.println(Integer.MAX_VALUE); // 2^31-1
        System.out.println(Integer.MIN_VALUE); // -2^31
        //INTEGER의 데이터 범위는 -2147483648~2147483647

        //Long : 8byte로 구성
        System.out.println(Long.MAX_VALUE); // 2^63-1
        System.out.println(Long.MIN_VALUE); // -2^63
        //Long의 데이터 범위는 -9223372036854775808~9223372036854775807

        //정수형은 기본적으로 int
        //byte byteValue3 = 142;
        // 숫자 리터럴은 기본적으로 int이다.
        short shortA = 10;
        short shortB = 20;
        //short shortC = shortA + shortB; => short타입 두개를 더하면 short데이터타입의 크기가 넘어갈 수 있으므로 강제로 형변환을 해줘야 한다.
        short shortC = (short)(shortA + shortB);

        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt+1; // Overflow가 발생한다.

        //long veryBigInt = 10000000000; => int보다 큰 값을 넣을경우 에러가 발생한다. 이때 마지막에 L을 붙여준다.
        long veryBigInt = 10000000000L;

        //진수법 - Binary(2), Octal(8), Decimal(10), Hexadecimal(16)
        System.out.println(0b1101); // 2진수
        System.out.println(071); // 8진수
        System.out.println(1424); // 10진수
        System.out.println(0x11); // 16진수

    }
}
