package com.company.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        System.out.println("각 Player는 AI, Human으로 구분되며 Human의 경우 이름을 입력해주시면 됩니다.");
        System.out.println("Player1에 대한 정보를 입력해주세요.");
        String ex = sc.next();
        String name = sc.next();
        if(ex.equals("AI"))
            t.p1 = new AIPlayer(name);
        else
            t.p1 = new HumanPlayer(name);
        System.out.println("Player2에 대한 정보를 입력해주세요.");
        ex = sc.next();
        name = sc.next();
        if(ex.equals("AI"))
            t.p2 = new AIPlayer(name);
        else
            t.p2 = new HumanPlayer(name);
        int n = sc.nextInt();
        t.n = n;
        System.out.println("Player1 부터 게임을 시작합니다.");
        t.start();
    }
}
