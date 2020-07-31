package com.company.day4;

/**
 * N-D Array 연습
 */

public class NDArrays_Exam {
    public static void main(String args[]){
        int[][] matA = {{1,2,3}, {3,4,5}};
        int[][] matB = {{3,4,5}, {1,4,2}};

        int[][] matC = new int[matA.length][matA[0].length];
        //1. matA + matB를 구하고 출력하기
        for(int i=0; i<matA.length; i++){
            for(int j=0; j<matA[i].length; j++){
                matC[i][j] = matA[i][j] + matB[i][j];
                System.out.print(matC[i][j] + " ");
            }
            System.out.println();
        }

        //2. matA를 Transpose하고 출력하시오.
        int[][] matD = new int[matA[0].length][matA.length];
        for(int i=0; i<matA[0].length; i++){
            for(int j=0; j<matA.length; j++){
                matD[i][j] = matA[j][i];
                System.out.print(matD[i][j] + " ");
            }
            System.out.println();
        }
    }
}
