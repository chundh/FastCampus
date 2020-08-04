package com.company.day2;

/**
 * 생성자(Constructor)
 * 클래스에서 인스턴스를 생성할 때 사용하는 메소드
 * new 키워드를 사용할 때 호출되는 메소드
 *
 * 기본 생성자(Default Constructor)
 * 파라미터 생성자(Parameter Constructor)
 */

class Constructor{
    int x;
    int y;
    String z; // z는 String이기 때문에 자동으로 초기화 될 때 null로 초기화 된다. null : 아무것도 참조하고 있지 않다.
    public Constructor(){ // 기본 생성자. 구현하지 않아도 기본적으로 생성되어있다. 직접 생성하여 초기화 값을 정할 수 있다.
        x = 1;
        y = 2;
        z = "초기화";
    }
    public Constructor(int x, int y, String z){
    // 기본생성자를 오버 로딩하여 파라미터 생성자를 만들 수 있다.
        this.x = x; // this는 멤버변수를 표기하기 위해 사용될 수 있다. this.x는 호출한 객체의 멤버 변수 x이다.
        this.y = y;
        this.z = z;
    }

    public Constructor(int a, int b){
        this(a,b,""); // 이와 같은 방법으로도 초기화 가능. this는 무조건 메소드의 첫번째 줄에 들어가야 한다.
    }
    // public은 외부에서 접근이 가능하고, private는 외부에서 접근이 불가능하다.

}

public class Constructor_Class {
    public static void main(String[] args) {
        Constructor c = new Constructor();
        System.out.println(c.x + " , " + c.y + " , " + c.z);
        Constructor c1 = new Constructor(10, 20, "c");
        System.out.println(c1.x + " , " + c1.y + " , " + c1.z);
    }
}

