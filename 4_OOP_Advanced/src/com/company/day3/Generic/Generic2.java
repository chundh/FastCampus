package com.company.day3.Generic;

/**
 * 제네릭 타입의 상속
 */

class GFoo<T> {

}

interface IGFoo<D> {

}
// 타입 파라미터는 부모 제네릭의 타입 파라미터를 모두 채워줘야 한다.
// 부모 파라미터 외의 추가적인 파라미터도 사용할 수 있다.
class GIGFoo<K, T,D> extends GFoo<T> implements IGFoo<D>{

}
// 부모 클래스/인터페이스들이 동일한 타입의 파라미터를 넘겨줄 수 있다.
class IGIFoo<T> extends GFoo<T> implements IGFoo<T>{

}
// 타입 제한을 하지 않으면 <extends Object>와 동일하다.
class GenericNoTypeLimitation<T extends Object>{}

// extends를 통해서 부모 클래스를 제한할 수 있다.
class GenericTypeLimitation<T extends Number & Cloneable>{ // Number 추상클래스, Cloneable 인터페이스를 상속하는 클래스만 T로 올 수 있다.

}

//제네릭 메소드
class GenericMethod {
    // 제네릭 타입의 스태틱 메소드는 가능하다. 스태틱 변수는 절대 생성할 수 없다.
    public static <T> T staticMethod(T t){ // 제네릭 클래스의 파라미터와 제네릭 메소드의 파라미터는 별개이다.
        //T라는 특정 자료형의 변수가 들어오면 알아서 타입에 맞춰서 메소드가 진행된다.
        //클래스 생성시에 선언만되고, 런타임 시점에 정의와 구현이 이루어진다. -> 동적바인딩이 이루어진다.
        return t;
    }
    public int method(int x){
        return x;
    }
    public <T> T method(T x){
        return x;
    }
}

// 와일드 카드
class WildFoo{

}
class WildBar extends WildFoo{

}
class WildGeneric<T>{

}

// 와일드 카드는 메소드의 입력 타입에 제네릭이 쓰일 경우
// 제네릭의 타입 변수를 결정하지 않거나 제한할 수 있다.
class WildCard{
    //public void method1(WildGeneric<?> x){} // ?를 쓰면 아무거나 다 들어올 수 있다.
    public void method1(WildGeneric<? extends Object> x){} // <?>는 <? extends Object>와 같다.
    public void method2(WildGeneric<? extends WildFoo> x){} // WildFoo, WildBar 가능
    public void method3(WildGeneric<? super WildBar> x){} // Object, WildFoo, WildBar 가능. WildBar포함 상위 클래스가 다 가능.
}

public class Generic2 {
    public static void main(String[] args) {
        // 이전에는 다른 변수타입을 처리하기 위해 오버로드, 오버라이딩을 했지만 제네릭을 사용하면 쉽게 처리 가능하다.
        // 동적 바인딩 -> 컴파일 타임에는 동작이 완전히 정의가 되지 않는다. 런타임에 결정이 된다.
        GenericMethod.staticMethod("abcd");
        GenericMethod.staticMethod(12345);
    }
}
