package com.company.day4;

/**
 *
 */

public class NDArrays_Class {
    public static void main(String args[]){
        //선언
        int[][] arr = new int[10][5];
        int[][] arr1 = new int[10][];
        for(int i=0; i<arr1.length; i++){
            arr1[i] = new int[5];
        }
        int[][] arr2 = new int[5][];
        arr2[0] = new int[1];
        arr2[1] = new int[5];
        arr2[2] = new int[2];

        int[][] arr3 = {{1,3,2}, {1,2}, {4,5,3}}; // int[3][]
        for(int[] array : arr3){
            for(int val : array)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
