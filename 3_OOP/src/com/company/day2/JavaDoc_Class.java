package com.company.day2;

// 다 만든 후 Tools -> Generate JavaDoc -> 파일 설정 해준 후 생성 폴더 지정 후 Other Command Line에 -encoding utf8 입력 후 ok하면 생성됨
// 보통 외부에 보여지는 부분만 작성을 한다

/**
 * 클래스에 대한 설명
 * 설명하고자 하는 것 바로위에 /**를 생성하면 JavaDocs가 생성된다.
 * @author Dohee Chun
 */
class JavaDocs{
    /**
     * 멤버 변수에 대한 설명
     */
    int memberInt;
    String memberString;

    /**
     * 메소드에 대한 설명
     * @param str 입력인자에 대한 설명
     * @return 리턴값에 대한 설명
     */
    public int methoadA(String str){
        return str.length();
    }

    /**
     * 생성자에 대한 설명
     * @param memberInt 입력인자에 대한 설명
     * @param memberString 입력인자에 대한 설명
     */
    public JavaDocs(int memberInt, String memberString) {
        this.memberInt = memberInt;
        this.memberString = memberString;
    }
}

public class JavaDoc_Class {
    public static void main(String[] args) {
        JavaDocs j = new JavaDocs(1, "String");
    }
}
