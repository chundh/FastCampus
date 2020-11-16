package com.company.day11.NIO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio(New Input/Output)
 * io stream : 입/출력 노드가 구분되어 있다.(BufferReader, BufferWriter)
 * nio channel : 입/출력을 모두 처리할 수 있다.
 * - 채널을 이용해서 입/출력을 모두 처리한다.
 * - 기본적으로 버퍼를 사용한다.
 * - nio는 non-blocking을 지원한다. (비동기식)
 *   - 읽기/쓰기를 진행하는 동안 다른 작업을 할 수 있다.
 */

public class nio {
    public static void main(String[] args) throws URISyntaxException {
        // 아래 세 가지 방법으로 path를 만들 수 있다.
        Path path = Paths.get("1.txt");
        Path path1 = Paths.get("Users", "dohee","1,txt"); // 두번째 파라미터에 목록을 쭉 작성할 수 있다.
        Path path2 = Paths.get(new URI("file:///users/.."));

        // Paths -> get정적메소드
        // Files -> createFile, createDirectory ...

        /**
         * Buffer -> Direct Buffer , Non Direct Buffer가 있다.
         * Direct Buffer: OS에 직접 요청한다.
         *   - 사용가능한 크기가 크다.(JVM이 아닌 OS에 요청하기 떄문에)
         *   - 생성 속도는 느리다(OS와의 통신이 필요하다)
         *   - 입출력 성능이 좋다.
         *   - ByteBuffer만 생성 가능하다.
         *   - nio는 ByteBuffer를 사용한다.
         *   - OS의 메모리에서 할당받아오기 때문에 JVM의 힙영역보다 데이터 처리 효율이 높다.
         * Non Direct Buffer: JVM 메모리에 요청한다.
         *   - 사용가능한 크기가 작다.(JVM에 의해 제한된다.)
         *   - 생성 속도가 빠르다.(JVM에 있는 자원을 바로 사용)
         *   - 입출력 성능은 비교적 떨어진다.
         *   - JVM의 Heap 영역에서 데이터 처리를 하기에 OS영역의 메모리보다 속도가 느리다.
         * -> 자주 많이 써야하는 상황에서는 Direct Buffer를 쓰는것이 좋다.
         * -> 잠깐 쓰고 말 Buffer라면 생성 속도가 빠른 Non Direct를 쓰는 것이 좋다.
         * -> Direct Buffer가 생성이 오래 걸리고, 접근하는데 시간이 걸리지만 절대적으로 메모리에서 데이터 처리를 하는 속도가 빠르다.
          */

        ByteBuffer buff = ByteBuffer.allocateDirect(1024);
        ByteBuffer buff1 = ByteBuffer.allocate(1024);
        // ByteBuffer를 제외한 나머지 Buffer는 allocateDirect 메소드가 없다.
        // -> ByteBuffer만 Direct Buffer를 사용할 수 있다. OS에 요청할 때 Byte크기로 요청한다.
        CharBuffer cBuff = CharBuffer.allocate(1024);
        // 아래의 방식처럼 ByteBuffer를 사용해서 다른 Buffer를 생성할 수 있다.
        DoubleBuffer dBuff = buff.asDoubleBuffer();


        Path src = Paths.get("1.txt");
        Path dst = Paths.get("2.txt");
        try{
            FileChannel channel1 = FileChannel.open(src, StandardOpenOption.READ);
            FileChannel channel2 = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate((int) channel1.size());
            read = channel1.read(readBuffer);
            if(read == -1){
                // 읽기에 실패한 경우
                System.out.println("Fail");
                throw new IOException();
            }
            readBuffer.flip(); // position이 0이 된다.
            channel2.write(readBuffer); // position부터 limit까지 쓴다.
            readBuffer.clear();

            // 버퍼의 크기가 작다면 반복문을 통해 파일을 입/출력하도록 한다.
//            while((read = channel1.read(readBuffer)) != -1){
//                readBuffer.flip();
//                channel2.write(readBuffer);
//                readBuffer.clear();
//            }

            // Buffer 사용법
            // capacity, limit, position, mark
            // 0 -> mark -> position -> limit -> capacity

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
