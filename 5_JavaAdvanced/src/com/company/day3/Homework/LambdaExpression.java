package com.company.day3.Homework;

import java.util.Scanner;

/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 *
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 *
 */

interface Solution<T, R> {
    R solve(T t);
}

class Algorithm<T, R> {
    boolean test(T input, R groundtruth, Solution<? super T, ? super R> solution) {
        // TODO: solution을 실행하고, 이것이 정답(groundtruth)와 일치하는지 테스트하여 일치 여부를 출력.
        if(solution.solve(input) == groundtruth) {
            return true;
        }else {
            return false;
        }
    }
}

public class LambdaExpression {
    public static void main(String[] args) {
        // TODO: test를 이용하여 알고리즘 문제를 하나 이상 풀이하고 테스트 결과를 출력하시오.
        Algorithm<Integer, Integer> algorithm = new Algorithm<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(algorithm.test(a, b, s -> solution(a,b)));
    }

    public static int solution(int a, int b){
        if(a==b){
            return b;
        }else{
            return a;
        }
    }
}