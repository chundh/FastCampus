package com.company.day9.ThreadPool;

import java.util.concurrent.*;

/**
 * Thread Pool
 * - 스레드를 직접 만들어 사용할 경우, 작업을 마친 스레드는 종료됨
 *   - 멀티스레드 작업을 계속할 경우 스레드를 생성/삭제하는 오버헤드가 있다.
 * - 스레드 풀
 *   - 미리 스레드를 생성해 두고, 작업만 스레드에 할당하여 동작
 *   - 미리 생성해둔 스레드의 집합을 스레드 풀이라고 함
 *   - 배치 작업(모아두고 한번에 처리하는 작업)에 많이 사용
 *   - 스레드 순서를 제어해야 할 필요가 없는 작업에 주로 사용한다.
 *   
 *   1. 스레드 풀 생성
 *   2. 스레드에 할당할 작업 생성
 *   3. 스레드에 작업 요청
 *   4. 스레드 종료(동기화)
 */
public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        /* 1.newCachedThreadPool 사용
           - 초기 스레드가 0개
           - 코어 스레드가 0개. 코어스레드 : 일하지 않아도 살려두는 스레드
           - 요청 작업보다 스레드가 부족하면 새 스레드를 생성
           - 60초동안 일하지 않은 스레드는 제거한다.
           - 안정적으로 스레드의 수를 늘렸다, 줄였다 한다.
        */
        ExecutorService pool1 = Executors.newCachedThreadPool();
        /* 2. newfixedThreadPool
            - 초기 스레드 nThreads개
            - 코어스레드 nThreads개
            - 작업하지 않는 스레드도 제거하지 않고 살려둔다. (한번 스레드 수를 증가시키면 줄어들지 않는다.)??
            - 동작에 실패하는 스레드의 경우 그 자리를 대기중이던 스레드가 대체한다.
         */
        ExecutorService pool2 = Executors.newFixedThreadPool(10);

        // 3. 직접 ThreadPool을 만드는 방법.
        ExecutorService es = new ThreadPoolExecutor(
                10, // 코어 스레드 개수
                100, // 최대 스레드 개수
                120, // 대기 시간
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>() // 요청 -> 작업을 쌓아둘 큐 -> 스레드를 할당한다.
        );
        class Work implements Runnable{
            // 작업 생성
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }
        class CallableWork implements Callable<String>{
            @Override
            public String call(){
                while(true){
                    System.out.println(1);
                    try {
                        int idx = 1;
                        Thread.sleep(10);
                        if (idx == 2)
                            break;
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        System.out.println("break");
                        break;
                    }
                }
                return "작업 종료";
            }
        }
        // 스레드에 작업 요청
        Future<String> future;
        future = pool1.submit(new CallableWork());
        for (int i = 0; i < 100; i++) {
            pool1.submit(new Work());
//            pool1.submit(new CallableWork());
        }
        pool2.shutdown();
        // 스레드 풀은 자동 종료가 안되기 때문에, 직접 스레드들을 종료해 주어야 한다.
        pool1.shutdown(); // Thread.join()과 마찬가지로 작업이 끝나기를 기다렸다가 종료한다. nonblock이다.
        future.cancel(true);
        // 실행중인 Callable 객체를 취소할 수 있다.
        // 실행중인 객체에 Interrupt를 발생시킨다.
        // false인 경우 Interrupt를 발생시키지 않지만 해당 객체의 get을 실행할 수 없게 한다.(CancellationException발생)

        Thread.sleep(1000);
        try {
            System.out.println(future.get());
            // get()은 Blocking method이다. CallableWork이 다 끝나고 결과값이 들어와야 코드가 진행된다.
            // 이때 get()이 영원히 기다릴 수 있기 때문에 timeout을 설정할 수 있다.
            // cancel을 하면 get을 할 수 없다.
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
