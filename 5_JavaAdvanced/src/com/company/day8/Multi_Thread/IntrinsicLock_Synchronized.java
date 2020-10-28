package com.company.day8.Multi_Thread;

/**
 * Intrinsic Lock(고유락)과 synchronized 키워드
 * - 자바의 모든 객체(Object)는 고유 락을 갖고있음
 *   - 객체의 소유권을 결정하는 내부적인 구현 -> 소유권은 독점적이다.
 * - synchronized를 이용하면 객체의 고유 락의 소유권을 가져올 수 있다.
 *   - 소유권이 이미 점유된 경우에는 Blocking으로 동작
 * - 멀티 쓰레드를 사용할 때 안전하게 데이터를 공유하는 방법이다.
 * - 소유권이 있는 쓰레드가 종료되면 락을 반환하고, Blocking상태에서 대기중이던 쓰레드에게 락 권한이 넘어간다.
 */

// 1. Object 객체의 Intrinsic Lock을 이용한 구현. 거의 안쓰는 방법
class Counter{
    private Object lock = new Object();
    private int count = 0;
    public int increaseCount(){
        synchronized (lock){ // lock이라는 객체를 소유해야만 안의 내용을 동작시킬 수 있다.
            return ++count;
        }
        // return ++count; // 읽고, 수정하고, 쓰는 작업이다.
        // 경쟁적으로 스레드에서 하나의 자원에 접근할 때, 읽고 수정하고 쓰기 전에 다른 스레드에서 값을 읽으면 올바른 계산이 되지 않는다.
    }
    public int getCount() {
        return count;
    }
}

// 2. this객체의 lock를 이용한 구현. 가장 선호되는 방법.
class Counter2{
    private int count = 0;
    public int increaseCount(){
        synchronized (this){ // lock 객체를 소유해야만 안의 내용을 동작시킬 수 있다.
            return ++count;
        }
    }
    public int getCount() {
        return count;
    }
}

// 3. 메소드에 synchronized 키워드를 사용한 구현
class Counter3{
    private int count = 0;
    public synchronized int increaseCount(){ // 메소드를 실행하기 위해서는 해당 객체의 lock을 소유하고 있어야 한다.
        return ++count;
    }
    public int getCount() {
        return count;
    }
}

public class IntrinsicLock_Synchronized {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        for(int j=0; j<100; j++) {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    // c라는 공유객체가 있을 때, 멀티스레드로부터 안전한 영역을 생성하는 방법
                    // 4. 실행시에 synchronized 키워드를 사용한 구현
                    synchronized (c) {
                        c.increaseCount();
                    }
                }
            }).start();
        }
        /*
        for(int j=0; j<100; j++) {
            new Thread(() -> {
                synchronized (c) {
                // 이렇게 구현하면 멀티쓰레드의 의미가 없다.
                // 쓰레드의 실행이 끝날 때 까지 아무 일도 진행되지 않는다.
                // 사실상 단일 쓰레드보다 더 효율이 안좋다.(context switching 오버헤드의 발생)
                    for (int i = 0; i < 100; i++) {
                        c.increaseCount();
                    }
                }
            }).start();
        }
         */
        Thread.sleep(1000);
        System.out.println(c.getCount());
    }
}
