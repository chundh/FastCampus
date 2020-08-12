package com.company.PairProgramming1;

import java.util.Scanner;

public class Player implements Inputtable {
    private String name;
    private int numWin;
    static Gomoku g;

    public Player(String name){
        this.name = name;
    }

    @Override
    public void getKeyboardInput() { // position class에 x,y좌표로 이루어진 객체 생성
        Scanner scanner = new Scanner(System.in);
        int flag=1;
        Position position = null;
        while(true){
            if(flag==-1){
                break;
            }
            System.out.println("좌표를 입력하세요");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(x>=15 || x<0 || y>=15 || y<0){
                System.out.println("범위를 초과했습니다. 다시 입력해주세요");
                continue;
            }
            if(g.arr[x][y].equals("-")){
                flag = -1;
                position = new Position(x, y);
            }
        }
        g.play(this, position);
    }

    public String getName() {
        return name;
    }

    public int getNumWin() {
        return numWin;
    }

    public void setNumWin(int numWin) {
        this.numWin = numWin;
    }
}