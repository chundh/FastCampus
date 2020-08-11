package com.company.day2.Interface;

import java.util.Scanner;

/**
 * 다형성을 통하여 하나의 인터페이스를 활용해 여러기능을 하는 클래스를 쉽게 만들 수 있다.
 */

class Calculator{
    ArithmaticOperator op;
    public Calculator(ArithmaticOperator op) {
        this.op = op;
    }

    public int run(int x, int y) {
        return op.operate(x, y);
    }
    public long run(long x, long y){
        return op.operate(x, y);
    }
    public double run(double x, double y){
        return op.operate(x, y);
    }
}

class Runner{
    public static void run(ArithmaticOperator op, int x, int y){
        System.out.println(op.operate(x, y));
    }
}

public class Main {
    public static void main(String[] args) {
        ArithmaticOperator op; // op변수는 Add, Subtract, Multiply, Divide 객체를 모두 받을 수 있다.
        op = new Multiply();
        System.out.println(op.operate(10,20));
        op = new Add();
        System.out.println(op.operate(10, 20));

        // 다형성을 활용하여 다양한 객체를 받는 배열을 만들 수 있다.
        ArithmaticOperator[] ops;
        ops = new ArithmaticOperator[]{new Add(), new Multiply()};
        for(ArithmaticOperator o: ops){
            System.out.println(o.operate(1,4));
        }

        // 다형성을 활용한 예
        Calculator add = new Calculator(new Add());
        Calculator sub = new Calculator(new Subtract());
        System.out.println(add.run(10, 20));
        System.out.println(sub.run(20, 15));
        
        Runner.run(new Add(), 10, 15);


        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(); // 3
        for(int i=0; i<n; i++){
            int[] arr = new int[3];
            int[] arr2 = new int[6];
            for(int j=0; j<6; j++){
                arr2[j] = sc.nextInt();
            }
        }
    }
}
