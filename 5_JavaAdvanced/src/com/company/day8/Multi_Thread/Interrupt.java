package com.company.day8.Multi_Thread;

public class Interrupt {
    public static void main(String[] args) {
        Thread p1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("p1 interrupted");
            }
            System.out.println("p1");
        });
        Thread p2 = new Thread(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p1.interrupt(); // 기존 동작을 방해하고 반응을 강제하는 메소드
            System.out.println("p2");
        });
        p1.start();
        p2.start();
    }
}
