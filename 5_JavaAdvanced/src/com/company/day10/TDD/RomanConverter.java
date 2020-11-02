package com.company.day10.TDD;

/**
 * I -> 1
 * II -> 2
 * III -> 3
 * IV -> 4
 * ...
 */

/**
 * TDD (Test-Driven Development) 테스트 주도 개발
 * - `실패하는` 테스트 케이스를 먼저 작성하고, 이것을 통과시키는 방식으로 코드를 구현하는 방식
 * - 테스트 케이스 작성 -> 코드 구현 -> (커밋) -> (리팩토링) -> 테스트 케이스 작성 -> 코드 구현을 반복하는 방식
 * - 지속적으로 테스트 케이스를 통과해나가면서 코드를 개선하는 것.
 *
 * - 도메인 지식이 없어도 테스트케이스를 작성할 수 있다는 관점에서 시작.
 */

public class RomanConverter {
    private String roman = "";

    public int transform(){
        if(roman.equals("")) {
            throw new ArithmeticException();
        }
        if(roman.contains("X")){
            return 10;
        }
        int count = 0;
        for(char c: roman.toCharArray()){
            if(c=='I'){
                count++;
            }
            else if(c=='V'){
                count+=3;
            }else if(c=='X'){
                count+=10;
            }
        }
        return count;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }
}
