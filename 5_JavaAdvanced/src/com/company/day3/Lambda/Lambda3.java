package com.company.day3.Lambda;

interface Run<T>{
    T run(String x);
}

public class Lambda3 {
    static void useRun(String x, Run<?> run){
        System.out.println(run.run(x));
    }

    public static void main(String[] args) {
        // 람다식이 가장 꽉찬 형태. 파라미터, return 등을 모두 넣을 수 있다.
        useRun("lambda", (String x)-> {return x;});
        useRun("lambda", x -> {return x;}); // ; 가 들어가면 {}필수
        useRun("lambda", x-> x);
    }
}
