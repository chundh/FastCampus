package com.company.day4;

/**
 * 공변 반환 타입 (Covariant return type)
 * 리턴타입이 상속의 상하 관계만 잘 맞춰져 있다면 어떤 것이 들어와도 사용이 가능하다.
 */

class Foo3{
    public Foo3 getInstance(){
        return this;
    }
}

class Bar3 extends Foo3{
    @Override
    public Bar3 getInstance(){ // 오버라이드의 경우 항상 리턴타입이 동일해야 하지만, 객체 자신을 반환하는 경우에는 다를 수 있다.
        return this;
    }
}

public class Poly3 {
}
