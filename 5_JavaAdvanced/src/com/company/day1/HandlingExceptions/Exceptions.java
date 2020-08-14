package com.company.day1.HandlingExceptions;

import javafx.animation.ScaleTransition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * 오류 / 예외
 * 오류 - 메모리 부족 또는 프로그램 실행이 꼬이는 경우
 *      더이상 어떻게 프로그램을 복구해야 할지 알 수 없다. -> 프로그램을 종료시키고, 프로그램의 문제를 해결해야 한다.
 * 예외 - 오류에 비해서 심각도가 낮고, 프로그램의 정상적인 흐름만 방해하는 경우
 *      -> 파일을 읽으려 했으나, 해당 파일이 없음
 *      -> 네트워크 연결 유실
 *     - 문제 상황을 처리하는 로직을 구현하여, 런타임에서 자연스럽게 해결 가능
 *
 * 예외 처리
 * - 예외가 발생했을 경우에, 이 상황을 '감지' 하고 '처리' 하는 코드
 * - try ~ catch, throw, finally 키워드를 이용
 *
 * Throwable 클래스를 상속하는 자식 클래스들로 이러한 문제를 해결
 */

public class Exceptions {
    public static void main(String[] args) {
        // try ~ catch
        try {
            // 예외가 발생할 수 있는 코드
            // 예외가 발생할 경우 예외 객체를 던짐 (throw)
        } catch (Exception e) { // 던져진 예외를 받음 (catch)
            // Exception 클래스 및 그 자식 클래스를 사용
            // 예외 상황을 처리하는 코드
            e.printStackTrace();
        }

        try {
            int[] integers = new int[10];
            integers[20] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace(); // 순서상 아래의 문장보다 먼저 실행되어야 하지만 IDE의 버그로 출력 순서가 다르다. 콘솔에서는 정상으로 나온다.
        }

        // 다중 예외 처리
        try{
            // 아주아주 예민한 내용이 실행되는 부분
            // 특정 catch 구문에 선택되는 조건은 다형성에 의해서 결정된다.
            // 즉, catch하고 있는 클래스와 자식 클래스의 객체면 catch 가능.
            // catch를 여러개 만들 경우 순서도 신경써야 한다.
            } catch (ArithmeticException e){ // 첫 번째 캐치

//            } catch (FileAlreadyExistsException e) {// 첫 번째 캐치 후 두 번째 캐치
//
//            } catch (IOException e){

            } catch (Exception e){ // 나머지 모든 Exception을 모두 catch
                                   // 모든 Exception 객체의 조상. 그래서 모든 에러가 catch된다. 따라서 구문을 완벽히 아는 것이 아니면 안쓰는것이 좋다.
        }

        // try ~ catch ~ finally
        try {
            int[] integers = new int[20];
            integers[21] = 10;
            System.out.println("던졌다?");
        } catch (Exception e){
            System.out.println("받았다");
        } finally { // catch 발생 여부에 상관없이 실행
            System.out.println("마침내!");
            // try에서 생성한 리소스를 회수하기 위해
        }

        /**
         * 예외의 종류 2가지
         * - Check Exception
         *   -> Exception 클래스를 상속하고 있으면 Checked Exception
         *   -> 컴파일러에서 에러가 발생한다.
         *   -> try ~ catch를 작성하지 않으면 아예 빌드를 할 수 없다.
         *
         * - Unchecked Exception
         *   -> RuntimeException 클래스를 상속하고 있으면 Unchecked Exception
         *   -> try ~ catch를 작성하지 않아도 빌드도 되고 실행도 된다.
         *   -> 대표적으로 ArrayIndexOutOfBoundsException, AritmathicException가 있다.
         */

        FileInputStream file = null;
        try {
            file = new FileInputStream("a.txt");
            file.read();
        } catch (IOException e){
            System.out.println("파일 처리 실패");
        } finally {
            System.out.println("Finally Block");
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("파일을 닫지 못했습니다.");
                }
            }
        }

        // 위의 개선 버전
        // try ~ with ~ resources 구문
        // java 1.7 에서 추가된 기능
        // AutoClosable 인터페이스를 구현하는 리소스만 사용 가능(따로 .close()를 호출하지 않아도 된다.)
        try(FileInputStream file1 = new FileInputStream("A.txt")){
            file1.read();
        }catch (IOException e){
            System.out.println("파일 처리 실패");
        }
    }
}

class CheckedExceptionThrow{
    void methodA() throws IOException{ // methodA가 에러를 직접 처리하지 않고, 메소드를 호출하는 객체나 메소드가 예외를 처리하도록 위임
        FileInputStream file1 = new FileInputStream("a.txt");
        file1.read();
        file1.close();
    }
    
    void methodB(){
        try{
            methodA();
        } catch (IOException e) {
            System.out.println("메소드A 실패");
        }
    }
}

// UncheckedException의 경우 throws를 사용하지 않아도 된다. 자신이 처리를 못하면 알아서 호출한 메소드로 예외 처리를 위임한다.
class UncheckedExceptionThrows{
    void methodA(){
        int x = 10/0;
    }
    void methodB(){
        methodA();
    }

    public static void main(String[] args) {
        try {
            new UncheckedExceptionThrows().methodB();
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

    }
}

class Foo{
    void methodA() throws IOException{} // Checked Exception
}

class BarOne extends Foo{
    void methodA() throws IOException{} // throws를 한 메소드를 상속하는 경우 throws 까지 같이 상속받는다.
}
class BarTwo extends Foo{
    void methodA() throws FileNotFoundException {} // 부모 클래스 메소드에서 throws 한 클래스의 자식 클래스는 사용할 수 있다.
}

class BarThree extends Foo{
    //void methodA() throws Exception{}
    // 부모 클래스의 메소드를 오버라이드 할 떄는
    // 부모 클래스 메소드의 예외보다 더 조상인 예외는 던질 수 없다. Exception이 IOException보다 조상이다.
    // 오버라이딩을 할 때 부모 예외에 속하지 않는 다른 예외는 발생할 수 없도록, 구현하는 내용을 어느정도 제한하는 부븐.
}