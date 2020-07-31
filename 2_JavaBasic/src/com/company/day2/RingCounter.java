package com.company.day2;

public class RingCounter {
    public static void main(String args[]){
        int numBits = 12;
        int numCount = 19;
        int index = (numCount-1)%numBits;

        System.out.println(1 << index);
    }
}
