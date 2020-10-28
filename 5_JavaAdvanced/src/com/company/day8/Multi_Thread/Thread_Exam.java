package com.company.day8.Multi_Thread;

import java.util.TreeMap;

public class Thread_Exam {
    public static void main(String[] args) {
        Thread p1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("~");
                Thread.yield(); // 다른스레드로 동작 권한을 양보 후 바로 실행대기
            }
        });
        Thread p2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("*");
                try {
                    Thread.sleep(1); // Running 상태에서 Timed_Waiting 상태로 이동한다.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 아래와 같이 우선순위가 있으나, Straving하는 Thread를 방지하기 위해 OS가 알아서 우선순위를 조절한다.
        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MIN_PRIORITY);

        p1.start();
        p2.start();
    }
}
