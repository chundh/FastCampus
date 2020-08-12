package com.company.PairProgramming1;

/**
 * kim
 * chun
 * 1 2
 * 2 4
 * 1 0
 * 2 5
 * 1 1
 * 2 6
 * 1 7
 * 2 7
 * 1 0
 * 2 8
 */

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

//        if(flag==1){
//            flag=-1;
//            p1.getKeyboardInput();
//        }
//        else {
//            flag=1;
            p2.getKeyboardInput();
//        }
    }

    @Override
    public void printStatus() { // 오목판의 현재상태를 출력
        for(int i=0; i<15; i++){
            for(int j=0 ;j<15; j++){
                System.out.print(this.arr[i][j]);
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
                    int z = j;
                    if(arr[i][j].equals("O")){
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
                            System.out.println("Case 1 : 승리");
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
                            System.out.println("Case 2 : 승리");
                            return;
                        }
                        f=1;
                        z = j;
                        System.out.println(i + " , " + j);
                        for(int k=j; k<j+5; k++){ // 오른쪽 체크
                            if(k>=15 || k<0) {
                                f = -1;
                                break;
                            }
                            if(!arr[i][k].equals(arr[i][j])){
                                System.out.println(arr[i][k]);
                                f = -1;
                                break;
                            }
                        }
                        if(f==1){
                            System.out.println("Case 3 : 승리");
                            return;
                        }
                        f=1;
                        if(i-5>=0) {
                            for (int k = i; k < i - 5; k--) { // 왼쪽 아래 대각선 체크
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
                            if(f==1){
                                System.out.println("Case 4 : 승리");
                                return;
                            }
                        }
                    } else {

                    }
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
    }

    @Override
    public Player getWinner() {
        return null;
    }
}