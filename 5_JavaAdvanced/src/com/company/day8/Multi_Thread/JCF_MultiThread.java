package com.company.day8.Multi_Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class JCF_MultiThread {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = new Vector<>(); // vector는 내부적으로 sync가 구현되어있다.
        List<Integer> list2 = new ArrayList<>(); // ArrayList는 내부적으로 sync가 구현되어있지 않다.
        List<Integer> list3 = Collections.synchronizedList(list2); // 이를 통해 ArrayList에도 sync를 구현해줄 수 있다.
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
               for(int j=0; j<100; j++){
                   list1.add(1);
               }
            }).start();
        }
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                for(int j=0; j<100; j++){
                    list3.add(1);
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
    }
}