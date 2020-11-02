package com.company.day10.UnitTest;

/**
 * POJO: Plain Old Java Object
 * - 순수하게 자바의 특성만을 담고 있는 것(어노테이션 없고 등등)
 */

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int value){
        balance-=value;
    }
    public void deposit(int value){
        balance+=value;
    }
    public boolean isMinus(){
        if(balance<0)
            return false;
        return true;
    }
}
