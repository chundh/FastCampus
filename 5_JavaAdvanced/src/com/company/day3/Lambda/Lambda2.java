package com.company.day3.Lambda;

/**
 * 람다식을 사용하기 위한 조건.
 */

interface Runner<T>{
    T run(); // 단하나의 abstract Method가 있을때만 람다 사용 가능.
    default void method(){} // default 메소드는 상관없다.
}

public class Lambda2 {
    static void useRunner(Runner<?> runner){ // ?는 와일드카드. 어떠한 것도 들어올 수 있다.
        System.out.println(runner.run());
    }
    public static void main(String[] args) {
        //밑 두개가 같은 기능을 수행한다.
        useRunner(() -> "this is runner");
        useRunner(new Runner<Object>() {
            @Override
            public Object run() {
                return "this is runner";
            }
        });
    }
}
