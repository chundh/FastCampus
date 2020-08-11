package com.company.day2.Interface;

/**
 * 열거형 (Enumeration)
 * - 키워드 : enum
 * - 내부적인 구현은 java.lang.Enum 클래스를 상속
 *  -> 그렇기 떄문에 enum은 다른 클래스를 상속하지 못한다.
 * - 다른 클래스를 상속하지 못하지만 interface 구현은 가능하다.
 * - 열거형 타입에는 열겨형 상수와 null값 할당 가능
 * - 열거형도 클래스다.
 */

enum Job{ // 각 상수는 0부터 index를 가지지만, 심볼로만 상수를 사용하고 숫자는 사용하지 않는다.
    STUDENT, MARKETTING, DEVELOPER, CHIEF_EXECUTIONAL_OFFICER; // 대문자에 공백은 언더바로 표현하는것이 관례
}

class Foo1{
    enum Symbol{
        ONE, TWO, THREE
    }
}

enum Symbol{
    ONE, TWO, THREE; // 상수들이 각각 객체가 된다.
    public Symbol nextSymbol(){
        if(this.equals(ONE)){
            return TWO;
        }
        else if(this.equals(TWO)){
            return THREE;
        }
        else
            return ONE;
    }
}
//열거형 생성자를 이용한 enum 상수 초기화
enum Family{
    FATHER("아버지"), MOTHER("어머니"), SON("아들"), DAUGHTER("딸"); // 열거형 상수(객체)
    private String koreanWord; // 멤버 변수(객체에 속하는 변수)
    //private은 생략 가능, public 불가능
    private Family(String koreanWord){
       this.koreanWord = koreanWord;
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord(String koreanWord) {
        this.koreanWord = koreanWord;
    }
}

public class Enumeration {
    public static void main(String[] args) {
        Job job = Job.CHIEF_EXECUTIONAL_OFFICER; // 클래스 변수와 유사하게 사용

        if(job == Job.CHIEF_EXECUTIONAL_OFFICER){
            System.out.println("HI");
        }

        switch (job){ // enum을 switch문에 사용할 때는 case에 enum 값을 직접 입력한다.
            case STUDENT:
                return;
            case DEVELOPER:
                System.out.println(1);
            case MARKETTING:
                break;
            case CHIEF_EXECUTIONAL_OFFICER:
                System.out.println("Hi");
            default:
                System.out.println("no");
        }

        //열거형 메소드 활용
        Symbol sym = Symbol.ONE;
        Symbol nextSym = sym.nextSymbol();
        System.out.println(nextSym);

        // 열거형 생성자와 멤버 변수 활용
        Family family = Family.SON; // SON 객체가 생성되면서 객체의 koreanWord가 아들로 초기화 된다.
        System.out.println(family.getKoreanWord());
    }
}
