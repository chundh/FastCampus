package com.company.day2;

public class RingCounter {
    public static void main(String args[]){
        int numBits = 12;
        int numCount = 19;
        int index = numCount%numBits;
        String arr = "";
        for(int i=0; i<numBits; i++)
            arr+= "0";
        String answer = arr.substring(0,arr.length()-index) + "1" + arr.substring(arr.length()-index+1, arr.length());
        System.out.println(Integer.parseInt(answer,2));
    }
}
