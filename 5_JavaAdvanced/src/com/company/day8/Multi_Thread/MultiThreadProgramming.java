package com.company.day8.Multi_Thread;

/**
 * Multi-Thread Programming
 * - 여러개의 스레드를 사용하는 프로그래밍 기법
 *
 * Thread : 최소의 프로세스 동작 단위 -> 하나의 프로세스는 여러개의 스레드를 가질 수 있다.
 * Process : OS로부터 메모리를 할당받아 동작하는 프로그램의 실행 단위
 *           프로그램이 실제로 메모리에 상주하면서 동작할 때 프로세스가 된다.
 *           프로세스끼리 메모리를 공유하는 영역은 없다. 그래서 프로세스간의 통신이 어렵고, serialization등의 기술을 활용해 통신한다.
 *           - Serialization: 프로세스는 서로 다른 가상메모리를 갖고 있다. 객체등에는 메모리에서 저장되어있는 위치를 참조할 때 쓰는 참조값이 있는데
 *                            이것을 다른 프로세스로 보내도 메모리가 다르기 때문에 같은 값을 가져올 수 없다.
 *                            그래서 Serialization하여 객체를 Primitive타입(Byte 타입)으로 변환하여 전송한다.
 *
 * 장점 :
 * - 여러 동작을 병렬적으로 처리하여 CPU사용률을 향상한다. (CPU Utilization)
 *   - 인코딩, 렌더링작업 등..
 * - 시간이 걸리는 동작을 분리하여 프로그램의 응답성 향상
 *   - GUI, 게임, 앱 등을 구현할 때 동작을 분리
 *
 * 단점 :
 * - 디버깅이 어렵다.
 *   - 쓰레드가 동시에 동작하기 때문에 디버거로 확인하기 어렵다.
 *   - 디버거를 쓰거나, 디버깅을 위한 코드를 추가하면 동작이 변한다.
 * - 구현이 어렵다.
 *   - 쓰레드간의 동기화를 하기 위한 구현이 어렵다.
 *   - 쉽게 동기화하면 속도가 느려진다.(멀티스레드를 하는 의미가 없다)
 *   - Context Switching 오버헤드(명령 실행을 위해 부가적으로 소모되는 것)가 있기 때문에 동기화를 잘 못하면 오히려 더 느려진다.
 */

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Mythread");
    }
}
public class MultiThreadProgramming {
    public static void main(String[] args) throws InterruptedException {
        // Runnable을 익명의 내부클래스로 만들고, 메소드를 override하여 실행
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread");
            }
        });
        // p1.run(); -> main 메소드에 정의되어있는 run()메소드를 호출한것이다. 멀티 쓰레드x
        // p1.start(); // OS에 쓰레드 동작을 요청한다.
        // p1.start(); -> Thread객체는 1회용이므로 start()가 재실행 될 수 없다.
        
        // 2. 람다로 만들어서 쓰레드 실행
        Thread p2 = new Thread(() ->{
            System.out.println("Lambda Thread");
        });
        p2.start();
        p2.join(); // p2쓰레드가 끝날때까지 대기한다. 우선순위에 의해 실행순서를 맞추지 않고, 순서를 강제할 수 있다.
        // 위 처럼 쓰레드의 종료까지 작업을 대기시키는 것을 Blocking이라고 한다. <-> Non-Blocking
        // 밑의 p1쓰레드를 실행 대기 상태로 만들지 않는다.
        p1.start(); // p2쓰레드가 끝나고 나면 p1 쓰레드가 실행된다.
        p1.join();
        // p1.join(100) 해당 시간만큼 쓰레드의 종료를 기다리다가 종료 여부에 상관없이 다음 코드를 진행한다.
        // 하지만 p1이 끝날 때까지 프로그램은 종료되지않는다.

        // 3. 커스텀 객체로 생성해서 쓰레드 실행
        MyThread mt = new MyThread();
        mt.start();
        
        // 4. 구현후 즉시 실행
        new Thread(()->{
            System.out.println("IDEA"); 
        }).start(); // Sync나 join을 신경쓰지 않아도 되는 경우에 편하게 사용
    }
}
