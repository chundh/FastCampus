package com.company.tictactoe;

public class AIPlayer implements Player{
    String info;
    String name;
    int win_num;
    public AIPlayer(String name) {
        this.info = "AI";
        this.name = name;
        this.win_num = 0;
    }

    @Override
    public int getWinNum() {
        return this.win_num;
    }

    @Override
    public void setWinNum(int num) {
        this.win_num = num;
    }

    @Override
    public String getInfo() {
        return this.info;
    }
}
