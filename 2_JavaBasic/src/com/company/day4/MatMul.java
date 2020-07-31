package com.company.day4;

/**
 * 3x2 2x3=>3x3
 * 1 2     5 2 3
 * 4 5     6 2 4
 * 1 4
 */


public class MatMul {
    public static void main(String args[]){
        int [][] matA = {{1, 2} ,{4, 5}, {1,4}};
        int [][] matB = {{5, 2, 3}, {6, 2, 4}};
        int [][] matC = new int[matA.length][matB[0].length];

        for(int i=0; i<matA.length; i++){
            int num = 0;
            int cnt=0;
            while(true){
                if(cnt == matC[0].length){
                    break;
                }
                for(int j=0; j<matB.length; j++){
                    num += matA[i][j] * matB[j][cnt];
                }
                System.out.print(num + " ");
                matC[i][cnt] = num;
                cnt++;
                num = 0;
            }
            System.out.println();
        }
    }
}