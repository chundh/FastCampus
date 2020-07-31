package com.company.day4;

import java.util.Scanner;

public class MaxSum {
    public static void main(String args[]){
        int [] arr = {-4, 5, 12, -7, 52, -5, 7};

        int[] list = new int[arr.length];
        list[0] = arr[0];
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            list[i] = Math.max(list[i-1]+arr[i], arr[i]);
            if(list[i]>max)
                max = list[i];
        }
        System.out.println(max);
    }
}
