package com.company.day7.DesignPattern;

// 1. 싱글톤 패턴 : 단 하나의 객체만 형성이되는 클래스
// -프로그램 전체의 상태를 정의할 때 많이 사용(게임, GUI의 상태 등등)
public class Singleton{
    // 여기서 객체를 생성하면 프로그램 실행시에 객체가 생성되므로 사용되지 않을 경우 속도 저하의 원인이 될 수 있다.
    private static Singleton instance;
    public static Singleton getInstance(){ // 사용되는 시점에 객체를 생성한다. 로딩속도 개선, 메모리 낭비방지
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}
