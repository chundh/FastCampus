package com.company.day6.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식 (Regular Expreesion)
 * - 문자열을 다루는 패턴화된 작업을 정의하는 수식
 * - 문자열 매칭, 템플릿 일치 여부 확인, 템플릿 매칭 검색
 * - 정규표현식은 느리기 때문에 남용하면 안된다.
 */

public class regularExpression {
    public static void main(String[] args) {
        String regex = "abcdef";
        String str = "abcdefg";

        System.out.println(Pattern.matches(regex,str));

        // boundary는 문자열의 시작, 끝, 공백, 문장기호로 구분되는지 여부 확인
        Pattern pattern = Pattern.compile("\\bJava\\b");
        Matcher matcher = pattern.matcher("Java is Java and Java will be Java");

        while (matcher.find()){
            System.out.println(matcher.start() + " , " + matcher.end());
        }

        Pattern pattern1 = Pattern.compile("ID:");
        Matcher matcher1 = pattern1.matcher("ID: Ssamzang");
        System.out.println(matcher1.lookingAt()); // 패턴으로 시작하는지 확인
        System.out.println(matcher1.replaceFirst(""));
    }
}
