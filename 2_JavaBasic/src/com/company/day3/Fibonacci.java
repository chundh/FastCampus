package com.company.day3;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String args[]){
        int seqLength = 100;

        BigInteger[] arr = new BigInteger[seqLength];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        arr[2] = BigInteger.ONE;
        for(int i=3; i<seqLength; i++){
            arr[i] = arr[i-1].add(arr[i-2]);
        }
        System.out.println(arr[99]);
        // write codes here
    }
}
