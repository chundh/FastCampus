package com.company.day3;

/**
 * 메소드 재정의(Method Overriding)
 * Override -> 덮어 씌우다, 해킹해서 뭔가 달라지게 하다
 * 다형성(polymorphism)의 근간이 된다.
 *
 */

class person{
    public void writeCode(){
        System.out.println("아무 코드나 적음");
    }

}

class Student extends person{
    @Override // 적어주는 것이 관례
    public void writeCode(){
        System.out.println("능숙하게 코드 작성");
    }
}

class Dev extends person{
    @Override // 적어주는 것이 관례
    public void writeCode(){
        System.out.println("능숙하게 코드 작성");
    }
}

public class Method_Overriding_Class {
    public static void main(String[] args) {
        person p = new person();
        p.writeCode();
        Student st = new Student();
        st.writeCode();

        // 부모 클래스 자료형으로 자식 클래스를 받을 수 있다.
        person ps = (person) st;
        ps.writeCode(); // 부모 클래스 자료형으로 캐스팅 됬지만 자식 클래스에 오버라이드된 메소드가 동작한다.
        // 이를 다형성(Polymorphism)이라고 한다.
        // 부모 클래스 배열에 어떠한 자식클래스도 다 들어갈 수 있다.
        person[] people = new person[]{new Student(), new Dev()};
        for(person person1: people){ // 배열에 어떤 클래스가 올지 모르기 때문에 부모클래스로 전체 배열 처리가 가능하다.
            person1.writeCode();
        }

    }
}
