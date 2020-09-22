package com.company.day3.Homework;

import java.util.Scanner;
import java.util.Stack;

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
        return solution.solve(input) == groundtruth;
    }
}

public class LambdaExpression {
    public static void main(String[] args) {
        // TODO: test를 이용하여 알고리즘 문제를 하나 이상 풀이하고 테스트 결과를 출력하시오.
        Algorithm<Integer, Integer> algorithm = new Algorithm<>();
        int n = 6;
        int ans = 5;
        System.out.println(algorithm.test(n, ans, s -> solution(n,ans)));
    }

    public static int solution(int a, int b){
        int n = a;
        Stack<Integer> arr = new Stack<>();
        int[] dp = {10, 3, 7, 4, 12, 2};
        long answer = 0;
        for(int i=0; i<n; i++){
            int data = dp[i];
            while(arr.size()!=0 && arr.peek()<=data) arr.pop();
            answer+=arr.size();
            arr.add(data);
        }
        if(b == answer){
            return (int) answer;
        }else{
            return -1;
        }
    }
}