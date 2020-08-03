package com.company.day4;

/**
 *
 */

public class Arrays_Class {
    public static void main(String args[]){
        int[] integers;
        integers = new int[10];
        int[] arr = new int[10];
        // int arr[] => C에서 사용하던 방식. 이전의 방식이니 왠만하면 사용x

        integers[0] = 1;
        integers[3] = 5;
        integers[2] = 4;
        //각 데이터 값들은 자동으로 0으로 초기화된다.
        //각 데이터는 꼭 순서대로 하지 않아도 된다.

        int[] integers2 = new int[]{0,2,3,4,5,2,3,6}; //배열의 크기를 지정하지 않고 생성할 수 있다.
        //배열 사용시에 선언해준 범위 밖의 인덱스로 접근하면 에러 발생!

        float[] floats = new float[5];

        for(int i=0; i<floats.length; i++){
            floats[i] = (float) (i * 0.25);
            System.out.println(floats[i]);
        }

        //Enhanced for 아니면 for each 구문
        for(float floatval: floats){
            System.out.println(floatval);
        }

        //배열의 크기를 변경
        int[] src = {1, 2, 3, 4, 5};
        int[] disc = new int[10];
        for(int i=0; i<src.length; i++){
            disc[i] = src[i];
        }
        for(int val : src){
            System.out.println(val);
        }
        //위방식대로 하거나 아래의 시스템에서 제공하는 방식 활용
        System.arraycopy(src, 0, disc, 0, src.length); // src의 0번부터 있는 배열을 disc의 0번 부터 src.length만큼 입력.

    }
}
