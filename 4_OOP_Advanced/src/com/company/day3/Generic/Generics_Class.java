package com.company.day3.Generic;

/**
 * 제네릭 (Generics)
 * - 대상 객체에 타입을 입력하면서 사용하는 형식
 * - 미리 사용할 수 있는 타입을 명시해서 컴파일 타임에 체크 가능
 *   - 입력을 Object로 할 수도 있으나, 런타임에 instanceOf로 객체를 확인해야 함
 *   - 제네릭을 사용할 경우 이러한 과정 없이 간결하게 코드 작성을 할 수 있다.
 */

// 제네릭 클래스
// 클래스를 선언할때에는 설정되지 않은 타입이 있으며, 이것을 타입 파라미터로 설정
class GenericFoo<T> { // T: 타입 파라미터
    String name;
    T memberVar; // T를 자료형으로 사용하여 변수 생성 가능

    public GenericFoo(String name, T memberVar){ // T를 자료형으로 사용하는 메소드 생성 가능
        this.name = name;
        this.memberVar = memberVar;
    }
}
// 제네릭 인터페이스
interface GenericInterface<T>{ // 인터페이스도 제네릭 사용 가능

}
class HashMap<K, V> { // 여러개의 타입 파라미터도 쓸 수 있다.

}
class GenericBar<T>{
    // 문법적으로 문제가 있는 경우
    //static T classVar; // 스태틱 변수는 객체와 상관없이 클래스에 속한다. 객체 생성 전에 이미 생성이 되어야 하므로 T가 될 수 없다.
    //static void method(T var){} // 스태틱 메소드도 클래스에 속하므로 T가 올 수 없다.
    
    // 문법적으로 문제가 없을 것 같으나, 안정성 문제로 금지된 문법
    //T memberVar = new T(); // 안정성 문제때문에 new 키워드를 사용할 수 없다. T에 해당하는 생성자가 없을 수 있으므로 불가능하다.
//    {
//        Object obj = new Object();
//        if(obj instanceof T){
//            
//        }
//    }

}

public class Generics_Class {
    public static void main(String[] args) {
        GenericFoo<String> foo = new GenericFoo<String>("name", "var"); // foo 객체에 한해서 T는 String이다.
        GenericFoo<String> foo1 = new GenericFoo<>("name", "var"); // 뒤에 <>에는 데이터 타입을 안써도 된다.

        System.out.println(foo.memberVar + " , " + foo.name);

        GenericFoo<Integer> foo2 = new GenericFoo<>("name1", 4);
        System.out.println(foo2.memberVar + " , " + foo2.name);
    }
}
