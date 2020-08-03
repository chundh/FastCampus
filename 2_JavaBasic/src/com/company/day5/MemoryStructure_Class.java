package com.company.day5;

/**
 * 클래스와 객체의 메모리 구조
 * - 클래스 영역(Class area, method area, code are, static area)
 *  -> filed 정보, method 정보, type 정보, constant pool 이 포함됨
 * - 스택 영역(Stack area)
 *  -> method 호출 시 선언된 로컬 변수가 포함됨 (임시로 있다가 사라짐)
 * - 힙 영역(Heap area)
 *  -> new 키워드로 생성된 객체가 포함됨
 *  -> garbage collection이 동작하는 영역(GC)
 *     더이상 사용하지 않는 메모리를 알아서 반환하는 JVM의 기능(해당 객체를 더이상 사용하지 않으면 자동으로 반환)
 */

public class MemoryStructure_Class { // 클래스 영역
    int x, y; // 힙 영역
    String string = "문자열!!!"; // string 변수는 힙영역, "문자열!!!"은 constant pool에 저장된다.
                                // string은 객체이므로 힙 영역에 string의 참조형 값이, constant pool에 데이터 값이 저장된다.
    // 객체가 생성되면서 변수도 같이 생성되므로 객체와 같이 힙영역에 저장된다.
    public void method(int value){ // 클래스 영역
        // int value -> 스택 영역
        char c = '='; // 스택 영역
    }
}
