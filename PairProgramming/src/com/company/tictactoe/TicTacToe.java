package com.company.tictactoe;

import java.util.Scanner;

/**
 * AI가 무조건 이기게 하려면?
 *
 */

public class TicTacToe {
    static int[][] arr = new int[3][3];
    Player p1;
    Player p2;
    int cnt=0;
    int n;
    Scanner sc = new Scanner(System.in);
    public void start(){
        int flag=1; // 1은 p1, -1은 p2
        while(true) {
            if (this.p1.getWinNum() == n)
                break;
            else if (p2.getWinNum() == n)
                break;
            while (true) {
                int x = 0;
                int y = 0;
                if(flag==1) {
                    if (p1.getInfo().equals("AI")) {
                        x = (int) (Math.random() * 3);
                        y = (int) (Math.random() * 3);
                    } else {
                        System.out.println("좌표를 입력해주세요");
                        x = sc.nextInt();
                        y = sc.nextInt();
                    }
                }
                else{
                    if (p2.getInfo().equals("AI")) {
                        x = (int) (Math.random() * 3);
                        y = (int) (Math.random() * 3);
                    } else {
                        System.out.println("좌표를 입력해주세요");
                        x = sc.nextInt();
                        y = sc.nextInt();
                    }
                }
                System.out.println(x + " , " + y);
                if (flag == 1) {
                    if (arr[x][y] != 0) {
                        System.out.println("해당위치에 돌이 존재합니다.");
                    } else {
                        arr[x][y] = 1;
                        this.cnt++;
                        if(this.getResult(1)){
                            System.out.println("Player1이 승리했습니다.");
                            p1.setWinNum(p1.getWinNum()+1);
                            break;
                        }
                        flag = -1;
                        break;
                    }
                } else {
                    if (arr[x][y] != 0) {
                        System.out.println("해당위치에 돌이 존재합니다.");
                    } else {
                        arr[x][y] = -1;
                        this.cnt++;
                        if(this.getResult(-1)){
                            System.out.println("Player2가 승리했습니다.");
                            p2.setWinNum(p2.getWinNum()+1);
                            break;
                        }
                        flag = 1;
                        break;
                    }
                }
            }
        }
    }
    public boolean getResult(int flag){
        if(this.cnt==(arr.length*arr.length)) {
            System.out.println("결과가 나오지 않으므로 게임을 처음부터 시작합니다.");
            arr = new int[3][3];
            cnt=0;
            return false;
        }
        int cnt=0;
        int cnt1=0;
        for(int i=0; i<arr.length; i++){ // 가로, 세로로 같은지 검사
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == flag)
                    cnt++;
                if(arr[j][i] == flag)
                    cnt1++;
            }
            if(cnt==arr.length || cnt1 == arr.length){
                return true;
            }
            cnt=0;
            cnt1=0;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i][i] == flag)
                cnt++;
        }
        if(cnt==arr.length)
            return true;
        cnt = 0;
        for(int i=arr.length-1; i>0; i--){
            if(arr[arr.length-i-1][i] == flag)
                cnt++;
        }
        if(cnt==arr.length)
            return true;
        return false;
    }
}
