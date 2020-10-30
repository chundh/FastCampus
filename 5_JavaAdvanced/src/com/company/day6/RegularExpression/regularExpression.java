package com.company.day6.RegularExpression;

import java.util.regex.Pattern;

/**
 * 정규표현식 (Regular Expreesion)
 * - 문자열을 다루는 패턴화된 작업을 정의하는 수식
 * - 문자열 매칭, 템플릿 일치 여부 확인, 템플릿 매칭 검색
 */

public class regularExpression {
    public static void main(String[] args) {
        String regex = "abcdef";
        String str = "abcdefg";

        System.out.println(Pattern.matches(regex,str));
    }
}
