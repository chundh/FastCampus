package com.company.day8.Multi_Thread;

/**
 * 데몬 스레드(Daemon Thread)
 * - 다른 스레드가 모두 종료될 경우 스스로 종료되는 스레드
 * - 무한 루프로 대기하면서 동작하는 구현이 많다.
 *   - 일정 시간마다 동작 or Interrupt에 의해 동작
 */

class AutoSaver extends Thread{
    public AutoSaver(){
        this.setDaemon(true); // 메인 스레드가 종료되면 스스로 종료되도록 설정해준다.
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Auto Save");
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        new AutoSaver().start();
        for (int i=0; i<15; i++){
            Thread.sleep(1000);
        }
    }
}
