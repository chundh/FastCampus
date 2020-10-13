package com.company.day7.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.*;

/**
 * 애노테이션(Annotation)
 * - 애노테이션의 사전적 정의 : 주석
 * - JVM, 컴파일러, 프레임워크 등에서 사용할 수 있도록 전달하는 메타데이터
 *
 * 기본 애노테이션
 * - @Override, @Deprecated, @SuppressWarning 등등
 *   - Deprecated : 앞으로 사용되지 않을 클래스, 메소드, 변수. 뒤에서 사용하지 말라는 의미
 *   - SuppressWarning : 특정 경고 메세지를 무시하도록 컴파일러에 전달.
 */

// @Target, Retention : 메타 Annotation
// @Target : Annotation을 사용할 수 있는 대상을 설정
    // TYPE : 클래스, 인터페이스 애노테이션 열거형
    // FIELD : 필드(멤버 변수), 열거형 상수
    // METHOD : 메소드
    // PARAMETER : 메소드의 입력 파라미터
    // CONSTRUCTOR : 클래스의 생성자
    // LOCAL_VARIABLE : 로컬 변수
    // MODULE : 모듈
    
// @Retention : Annotation 정보를 어디까지 유지할 것인가를 결정하는 Policy(정책)
    // SOURCE : 컴파일러가 사용. .java->.class로 변경하는 과정에서 쓰인다. .class파일에 포함되지 않는다.
    // CLASS : .class에 포함. JVM에 올라오지 않음
    // RUNTIME : .class에 포함. JVM에 올라와서 Reflection API에서 사용 가능
    // 실질적으로 컴파일러는 구현하지 않으므로 RUNTIME만 활용할 수 있다.
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
@interface SuppressWarningsCopy {
    String[] value();
}

//Custom Annotation
// 멤버 변수를 대상으로 하는, Reflection API에서 쓸 수 있는 Annotation
// Annotation 속성은 String[]인 value와 "data" 기본값을 가지는 valueTwo로 이루어진다.
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String[] value(); //Annotation 속성. 기본 속성 이름은 value.
    String valueTwo() default "Default String"; // 기본적으로 값을 정할 수 있다.
}

class AnnotationsUsage{

    @MyAnnotation("game")
    String game = "TicTactoe";
    // value는 String[]이므로 value에는 배열로 넣어줘야하지만 길이가 1이면 String만 넣어도 됨
    @MyAnnotation(value="server", valueTwo = "localhost")
    String serverIP ;

    @MyAnnotation(value="server", valueTwo = "0000")
    String serverPort ;

    @MyAnnotation("game")
    String gameMode = "AI vs AI";

    @MyAnnotation(value="db", valueTwo = "localhost")
    String database;
}

public class Annotation {
    public static void main(String[] args) throws IllegalAccessException {
        AnnotationsUsage obj = new AnnotationsUsage();
        Map<String, Object> gameProp = new HashMap<>();
        Map<String, Object> serverProp = new HashMap<>();
        Map<String, Object> dbProp = new HashMap<>();
        Field[] fields = AnnotationsUsage.class.getDeclaredFields();
        for(Field field: fields){
            // field에서 Annotation 정보를 가져오는 부분(Reflection API)
            MyAnnotation annotation = field.getDeclaredAnnotation(MyAnnotation.class);
            if(field.get(obj) == null){
                field.set(obj, annotation.valueTwo());
            }
            if(annotation.value()[0].equals("game")){
                gameProp.put(field.getName(), field.get(obj));
            }else if(annotation.value()[0].equals("server")){
                serverProp.put(field.getName(), field.get(obj));
            }else{
                dbProp.put(field.getName(), field.get(obj));
            }
        }
        System.out.println(gameProp);
        System.out.println(serverProp);
        System.out.println(dbProp);
    }
}
