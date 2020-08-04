package com.company.day2;

/**
 * 메소드 (Method)
 * - 객체가 하는 동작을 정의하는 작업을 수행하는 코드의 집합.
 * - 코드의 중복을 방지
 * - 유지보수성의 향상
 * - 코드의 가독성 개선
 */

class Foo{
    int value;
}

class Bar{
    public int add(int x, int y){ // int는 return type. int x, int y는 파라미터.
        return x+y;
    }
    // 선언(Declaration): ~한 것이 있다의 의미. 실제 구현은 x
    // 정의(Definition): 선언 + 구현(초기화).

    // static이 붙으면 정적 메소드, 클래스 메소드라 부른다.
    public static void classMethod(){ // void는 아무것도 반환하지 않는 return type.
        System.out.println("Class Method");
    }

    public static void swapPrimitive(int x, int y){
        // 메소드를 호출할때 값을 복사해서 넘긴다.
        // 기본형 타입(Primitive type)의 경우는 값이 복사되어서 넘어온다.
        // int x, int y의 사본이 넘어온다.

        int temp = x;
        x = y;
        y = temp;
        // 계산 후 데이터가 다 사라지면서 밖의 코드에는 영향을 미치지 못한다.
    }

    public static void swapReference(Foo x, Foo y){
        // Foo는 class이다. class는 참조형 변수이므로 값을 넘기지 않고 주소값을 넘긴다. Call by Reference
        // 실제 주소값으로 데이터를 가져와 계산을 해서 밖의 코드에도 영향을 미친다.
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
                            // 가변인자라 부른다.
    public static int sumAll(int... params){ // 갯수가 명확하지 않은 여러개의 int를 배열로 입력받을 수 있다. params는 배열이다.
        int sum = 0;
        for(int value: params){
            sum += value;
        }
        return sum;
    }

    public static float sumAll(float... params){
        // 메소드 오버로딩. Method Overloading.
        // 함수명은 같고, 입력 인자가 달라야한다.
        // 입력 인자의 개수도 다를 수 있다.
        float sum = 0;
        for(float value: params){
            sum += value;
        }
        return sum;
    }
}

class Person{
    static String korWord = "사람";
    Boolean isHungry = true;

    public static void describe(){ // static 메소드는 특정 객체의 변수를 변경하기 위해 사용하지 않는다. static 변수는 접근, 변경 가능
        System.out.println(korWord + "입니다.");
    }

    public void eat(){ // 인스턴스 메소드는 주로 객체의 변수를 변화시킨다.
        isHungry = false;
    }
}

public class Method_Class {
    public static void classMethod(){
        System.out.println("클래스 메소드 호출");
    }

    public void instanceMethod(){
        System.out.println("인스턴스 메소드 호출");
    }

    public static void main(String[] args) {
        Bar.classMethod();
        Bar bar = new Bar();
        System.out.println(bar.add(1,2));

        Person p1 = new Person();
        Person p2 = new Person();

        p1.eat();
        System.out.println(p1.isHungry);
        System.out.println(p2.isHungry);

        int x = 10;
        int y = 20;
        Bar.swapPrimitive(x, y);
        System.out.println(x + " , " + y);

        Foo fx = new Foo();
        fx.value = 10;
        Foo fy = new Foo();
        fy.value = 20;
        Bar.swapReference(fx, fy);
        System.out.println(fx.value + " , " + fy.value);

        System.out.println(Bar.sumAll(1,2,3,4,5,2,3,4));
        System.out.println(Bar.sumAll(1.2f, 3.4f, 6.3f));

        classMethod(); // 자신의 클래스 메소드이므로 바로 호출 가능
        Method_Class.classMethod();

        Method_Class mc = new Method_Class();
        mc.instanceMethod();
    }
}
