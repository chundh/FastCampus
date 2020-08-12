package com.company.PairProgramming1;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    String[][] arr; //
    Player p1;
    Player p2;

    int flag=-1;
    public Gomoku(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    @Override
    public void play(Player player, Position pos) {
        if(player.getName().equals(p1.getName())){ // 흑돌 -> X
            this.arr[pos.getX()][pos.getY()] = "X";
            System.out.println("흑돌 놓음");
        }
        else{ // 백돌 -> O
            this.arr[pos.getX()][pos.getY()] = "O";
            System.out.println("백돌 놓음");
        }
        printStatus();
        isFinished();
        threeThree(pos.getX(), pos.getY());

        if(flag==1){
            flag=-1;
            p1.getKeyboardInput();
        }
        else {
            flag=1;
            p2.getKeyboardInput();
        }
    }

    @Override
    public void printStatus() { // 오목판의 현재상태를 출력
        for(int i=0; i<15; i++){
            for(int j=0 ;j<15; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void initialize() { // 초기화
        arr = new String[15][15];
        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                arr[i][j] = "-";
            }
        }
        p1.getKeyboardInput();
    }

    @Override
    public void isFinished() { // 끝났는지 확인
        int f=1;
        for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                if(arr[i][j].equals("-")){
                    continue;
                } else {
                    check_Win(i, j);
                }
            }
        }
    }

    @Override
    public void reset() { // 초기화
        arr = new String[15][15];
        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                arr[i][j] = "-";
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("한판 더하실건가요? 안할거면 Q 할거면 아무거나 눌러주세요");
        String s = sc.nextLine();
        if(s.equalsIgnoreCase("q")){
            System.out.println(p1.getName() + " " + p1.getNumWin() + " - " + p2.getNumWin() + " " + p2.getName());
            System.exit(0);
        }
    }

    @Override
    public Player getWinner() {
        return null;
    }

    public void check_Winner(int i, int j){
        if(arr[i][j].equals("O")){ // 백돌 - p2
            p2.setNumWin(p2.getNumWin()+1);
            System.out.println(p2.getName() + ": " + p2.getNumWin() + "번 이겼다");
        }
        else{
            p1.setNumWin(p1.getNumWin()+1);
            System.out.println(p1.getName() + ": " + p1.getNumWin() + "번 이겼다");
        }
        reset();
    }

    public void check_Win(int i, int j){
        int f = 1;
        int z = j;
        for(int k=i; k<i+5; k++){ // 아래쪽 체크
            if(k>=15 || k<0) {
                f = -1;
                break;
            }
            if(!arr[k][j].equals(arr[i][j])){
                f = -1;
                break;
            }
        }
        if(f==1){
            check_Winner(i, j);
            return;
        }
        f=1;
        for(int k=i; k<i+5; k++){ // 오른쪽 아래 대각선 체크
            if(k>=15 || k<0 || z>=15 || z<0) {
                f = -1;
                break;
            }
            if(!arr[k][z].equals(arr[i][j])){
                f = -1;
                break;
            }
            z++;
        }
        if(f==1){
            check_Winner(i, j);
            return;
        }
        f=1;
        z = j;
        for(int k=j; k<j+5; k++){ // 오른쪽 체크
            if(k>=15 || k<0) {
                f = -1;
                break;
            }
            if(!arr[i][k].equals(arr[i][j])){
                f = -1;
                break;
            }
        }
        if(f==1){
            check_Winner(i, j);
            return;
        }
        f=1;
        if(i-5>=0) {
            for (int k = i; k > i - 5; k--) { // 왼쪽 아래 대각선 체크
                if (k >= 15 || k < 0 || z >= 15 || z < 0) {
                    f = -1;
                    break;
                }
                if (!arr[k][z].equals(arr[i][j])) {
                    f = -1;
                    break;
                }
                z++;
            }
            if (f == 1) {
                check_Winner(i, j);
                return;
            }
        }
    }

    public void threeThree(int x, int y){
        int threeCount = 0;
        int threeCountEach = 0;

        for(int k = 0; k < 15; k++){
            for(int h = 0; h < 15; h++){
                threeCount = 0;
                threeCountEach = 0;
                if(arr[k][h].equals("-"))
                    continue;

                // 가로
                for(int i = Math.max(h - 2, 0); i <= Math.min(h + 2, 14); i++){
                    if(arr[k][i].equals(arr[k][h])){
                        threeCountEach++;
                    } else {
                        threeCountEach = 0;
                    }
                    if(threeCountEach == 3){
                        threeCount++;
                    }
                    else if(threeCountEach==4){
                        threeCount--;
                    }
                }
                threeCountEach = 0;

                //세로
                for(int i = Math.max(k - 2, 0); i <= Math.min(k + 2, 14); i++){
                    if(arr[i][h].equals(arr[k][h])){
                        threeCountEach++;
                    } else {
                        threeCountEach = 0;
                    }
                    if(threeCountEach == 3){
                        threeCount++;
                    }
                    else if(threeCountEach==4){
                        threeCount--;
                    }

                }
                threeCountEach = 0;

                //대각선 왼쪽 아래에서 오른쪽 위로
                int z = Math.max(h - 2, 0);
                for(int i = Math.min(k + 2, 14); i >= Math.max(k - 2, 0); i--){
                    if(z>=15 || z<0)
                        break;
                    if(arr[i][z].equals(arr[k][h])){
                        threeCountEach++;
                    } else {
                        threeCountEach = 0;
                    }
                    if(threeCountEach == 3){
                        threeCount++;
                    }
                    else if(threeCountEach==4){
                        threeCount--;
                    }
                    z++;
                }
                threeCountEach = 0;

                //왼쪽 위에서 오른쪽 아래로
                z = Math.max(h - 2, 0);
                for(int i = Math.max(k - 2, 0); i <= Math.min(k + 2,14); i++){
                    if(z>=15 || z<0)
                        break;
                    if(arr[i][z].equals(arr[k][h])){
                        threeCountEach++;
                    } else {
                        threeCountEach = 0;
                    }
                    if(threeCountEach == 3){
                        threeCount++;
                    }
                    else if(threeCountEach==4){
                        threeCount--;
                    }
                    z++;
                }
                if(threeCount>=2){ // 33이다.
                    System.out.println("33이야");
                    if(arr[x][y].equals("X")){
                        p2.setNumWin(p2.getNumWin()+1);
                        System.out.println(p2.getName() + ": " + p2.getNumWin() + "번 이겼다");
                        reset();
                        return;
                    }
                    else {
                        p1.setNumWin(p1.getNumWin() + 1);
                        System.out.println(p1.getName() + ": " + p1.getNumWin() + "번 이겼다");
                        reset();
                        return;
                    }
                }
            }
        }
    }
}