package com.company.day2.homework;

class SingletonPattern{

    private static SingletonPattern singletonPattern;

    static SingletonPattern getInstance() {
        if(singletonPattern == null){
            singletonPattern = new SingletonPattern();
        }
        return singletonPattern;
    }

    private SingletonPattern(){

    }


}
public class SingletonPatternTest {
    public static void main(String[] args) {
        // SingletonPattern instance = new SingletonPattern(); // should fail
        SingletonPattern instanceOne = SingletonPattern.getInstance();
        SingletonPattern instanceTwo = SingletonPattern.getInstance();

        System.out.println(instanceOne == instanceTwo); // should be true
    }
}
