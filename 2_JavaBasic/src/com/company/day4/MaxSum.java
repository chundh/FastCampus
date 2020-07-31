package com.company.day4;

public class MaxSum {
    public static void main(String args[]){
        int [] integers = {-4, 7, 14, 9, -5, 4, 16, -22, 31};

        int answer = integers[0];
        int num = integers[0];
        for(int i=1; i<integers.length; i++){
            if(integers[i] >= 0){  // 배열의 수가 양수이면 더한다.
                if(num<0) // 이전 결과값이 음수인경우 해당 인덱스부터 다시 더하기 시작.
                    num = 0;
                num += integers[i];
            }
            else { // 배열의 수가 음수인 경우
                if (num + integers[i] < 0) { // 이전 결과값들과 배열의 수를 합쳤을 때 음수가 되면 다음으로 넘긴다.
                    if(answer<num+integers[i]) {
                        answer = num + integers[i];
                    }
                    num = 0;
                }
                else{
                    num += integers[i];
                }
            }
            if(num>answer)
                answer = num;
        }
        System.out.println(answer);
    }
}
