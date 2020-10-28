package com.company.day8.Multi_Thread;

import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * n개의 깃발을 놓고, 여러 스레드가 경쟁하는 sync 기법
 * n=1이면, BinarySemaphore라고 하고, lock과 유사하게 동작한다.
 *
 */

public class semaphore {
    public static void main(String[] args) {
        // 충분한 리소스가 있어야 작동되는 코드를 작성할 때 쓰기 좋다.
        Semaphore sem = new Semaphore(1);
        try {
            sem.acquire(); // 권한을 하나 획득한다.sem.acquire(10);이면 10개를 획득한다.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release(); // 권한을 반납한다. 한번에 여러개를 반납할 수 있다.
        sem.tryAcquire(); // 권한을 획득할 수 있으면 true, 못하면 false를 return한다. 못받아도 Blocking하지 않는다.(다음 코드로 진행)
    }
}
