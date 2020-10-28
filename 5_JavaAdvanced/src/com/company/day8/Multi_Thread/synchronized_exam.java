package com.company.day8.Multi_Thread;

/**
 * notify()와 wait()은 synchronized 안에서만 사용가능하다.
 * - notify()
 *   - 대기중인 다른 쓰레드 하나를 실행대기 상태로 만든다. 우선순위가 높은 쓰레드를 실행하고 싶겠지만, 이는 확정적으로 이루어지지 않는다.
 * - notifyAll()
 *   - 대기중인 모든 쓰레드를 실행대기 상태로 만든다. lock을 반환받기 위한 상태가 된다.
 * - wait()
 *   - lock을 반환하고 대기상태로 돌아가면서, 대기중이던 다른 쓰레드가 실행된다.
 *
 * - 메소드 특성상 반드시 notify/notifyAll 실행 후 wait을 실행해야 한다. wait을 두번 실행하면 서로 대기하는 데드락 상태가 된다.
 */

class WorkObject{
    public synchronized void methodA(){
        System.out.println("A called");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void methodB(){
        System.out.println("B called");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Mythread extends Thread{
    private final WorkObject workObject;
    boolean isA;
    public Mythread(WorkObject workObject, boolean isA){ // Dependency Injection
        this.workObject = workObject;
        this.isA = isA;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(isA){
                workObject.methodA();
            }else{
                workObject.methodB();
            }
        }
    }
}

public class synchronized_exam {
    public static void main(String[] args) {
        WorkObject sharedObj = new WorkObject();
        Thread p1 = new Mythread(sharedObj, true);
        Thread p2 = new Mythread(sharedObj, false);
        p1.start();
        p2.start();
    }
}
