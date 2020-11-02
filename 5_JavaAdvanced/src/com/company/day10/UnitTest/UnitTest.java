package com.company.day10.UnitTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 유닛 테스트 (Unit Test)
 * - 단위 테스트라고도 하며, 최소 단위의 테스트를 말한다.
 * - 최소단위: 메소드 단위(객체 단위)
 *   - 메소드는 객체의 속성을 변화시키는 Side Effect를 갖고 있기 때문이다.(순수함수 제외)
 *   - 환경 셋업, 환경 정리를 반드시 같이 하면서 진행해야한다.
 * 
 * 통합 테스트 (Integration Test)
 * - 전체 시스템의 동작을 확인하는 테스트
 */



public class UnitTest {

    private final List<Scorable> scoreList = new ArrayList<>();

    public void add(Scorable item){
        scoreList.add(item);
    }
    public int arithmeticMean(){
        int total = scoreList.stream()
                .mapToInt(Scorable::getScore)
                .sum();
        return total/scoreList.size();
    }

    /**
     * 기존의 임시적인 테스트 방법의 문제점
     * - 여러개의 테스트를 작성하기 어렵다.
     * - 여러개의 테스트를 실행할 때, 실행 순서에 따라 결과가 달라진다.
     * - 테스트의 결과가 성공적인지 파악하기가 어렵다.(개발자가 케이스의 결과값을 모두 계산해야하기 때문에)
     * - Production 코드와 Test 코드가 섞이게된다.
     */
    public static void main(String[] args) {
        UnitTest test = new UnitTest();
        test.add(()->5);
        test.add(()->7);
        System.out.println(test.arithmeticMean());
    }
}
