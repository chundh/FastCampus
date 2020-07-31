package com.company.day4;

public class Array_Exam {
    public static void main(String args[]){
        //가장 큰 수 찾기
        int[] arr = {42, 124, 32, 21, -123, 345, 753, 23};
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max)
                max = arr[i];
        }
        System.out.println(max);

        //두 번째로 큰 수 찾기
        int sec_max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=max){
                if(arr[i]>sec_max)
                    sec_max = arr[i];
            }
        }
        System.out.println(sec_max);

        int[] data = new int[2];
        data[0] = arr[0];
        if(arr[0]>arr[1]) {
            data[0] = arr[0];
            data[1] = arr[1];
        }else{
            data[0] = arr[1];
            data[1] = arr[0];
        }
        int num = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>num){
                num = arr[i];
                if(data[0]<num){
                    data[1] = data[0];
                    data[0] = num;
                }else{
                    if(data[1]<num)
                        data[1] = num;
                }
            }
        }
        System.out.println(data[0] + " , " + data[1]);
    }
}
