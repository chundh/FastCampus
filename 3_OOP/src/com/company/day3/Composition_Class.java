package com.company.day3;

/**
 * 클래스의 포함 관계(Class Composition)
 * 상속하고 유사하지만, 한 클래스가 다른 클래스의 객체를 포함하는 관계
 * 내부에 포함하고 있어 'HAS-A' 관계로 표현한다.
 */

// Develop 'HAS-A' 관계
// Develop 클래스는 MainMachine의 객체 하나를 보유한다. Composition
class MainMachine{
    String model;
    boolean isBroken = false;

    public MainMachine(String model){
        this.model = model;
    }
}

class Develop{
    String name;
    MainMachine mainMachine;

    public Develop(String name, MainMachine machine){
        this.name = name;
        this.mainMachine = machine;
    }

    public void writeCode(){
        if(mainMachine.isBroken == true){
            System.out.println("코딩을 할 수 없습니다.");
            return;
        }
        System.out.println(mainMachine.model + "(으)로 코딩하기");
        if(Math.random()>0.9)
            this.breakMachine();
    }

    public void breakMachine(){
        mainMachine.isBroken = true;
    }
}

public class Composition_Class {
    public static void main(String[] args) {
        MainMachine mac = new MainMachine("Macbook pro");
        Develop dev = new Develop("dev", mac);
        for(int i=0; i<10; i++){
            dev.writeCode();
        }
    }
}
