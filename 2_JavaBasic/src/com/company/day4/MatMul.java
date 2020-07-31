package com.company.day4;

public class MatMul {
    public static void main(String args[]){
        int [][] matA = {{1, 2, 3} ,{4, 5, 2}};
        int [][] matB = {{5, 2}, {6, 2}, {1, 0}};
        int [][] matC = new int[matA.length][matB[0].length];
        int x = matA.length-1;
        for(int i=0; i<matA.length; i++){
            int num = 0;
            for(int j=0; j<matB.length; j++){
                num += matA[i][j] * matB[j][i];
            }
            matC[i][i] = num;
            num = 0;

            for(int j=0; j<matB[0].length; j++){
                num += matA[i][j] * matB[j][x];
            }
            matC[i][x] = num;
            x--;
        }

        for(int i=0; i<matC.length; i++){
            for(int j=0; j<matC[0].length; j++){
                System.out.print(matC[i][j] + " ");
            }
            System.out.println();
        }
    }
}