package com.company.day2.Interface.homework;

/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 * s
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
}


class IntArrayList implements List{
    private int capacity;
    private int len;
    private int[] arr;
    public IntArrayList(int capacity){
        this.arr = new int[capacity];
        this.len = 0;
        this.capacity = capacity;
    }

    @Override
    public void append(int value) { // append(): List의 마지막에 value를 삽입한다.
        if(len>=capacity){
            int[] temp_arr = new int[capacity*2];
            for(int i=0; i<capacity; i++){
                temp_arr[i] = arr[i];
            }
            arr = temp_arr;
            capacity *= 2;
            System.out.println("배열의 최대 크기 확장 : " + capacity/2 + "에서 " + capacity + "으로");
        }

        arr[len] = value;
        len++;
    }

    @Override
    public void prepend(int value) { // prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
        if(len>=capacity){
            int[] temp_arr = new int[capacity*2];
            for(int i=0; i<capacity; i++){
                temp_arr[i] = arr[i];
            }
            arr = temp_arr;
            capacity *= 2;
            System.out.println("배열의 최대 크기 확장 : " + capacity/2 + "에서 " + capacity + "으로");
        }
        for(int i=len; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        len++;
    }

    @Override
    public void insert(int index, int value) { // index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
        if(len>=capacity){
            int[] temp_arr = new int[capacity*2];
            for(int i=0; i<capacity; i++){
                temp_arr[i] = arr[i];
            }
            arr = temp_arr;
            capacity *= 2;
            System.out.println("배열의 최대 크기 확장 : " + capacity/2 + "에서 " + capacity + "으로");
        }
        for(int i=len; i>=index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        len++;
    }

    @Override
    public void remove(int index) { // remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
        for(int i=index; i<capacity-1; i++){
            arr[i] = arr[i+1];
        }
        len--;
    }

    @Override
    public int get(int index) { // get(): index의 value를 반환한다.
        return arr[index];
    }

    @Override
    public void length() { // length(): List의 길이를 출력한다.
        System.out.println(this.len);
    }

    public void print(){
        for(int i=0; i<len; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class HomeWork{
    public static void main(String[] args) {
        IntArrayList intArrayList = new IntArrayList(5);
        intArrayList.prepend(5);
        intArrayList.prepend(4);
        intArrayList.prepend(3);
        intArrayList.prepend(2);
        intArrayList.prepend(1);
        intArrayList.insert(3, 2);
        intArrayList.append(1);
        intArrayList.print();
        intArrayList.remove(0);
        intArrayList.print();
        System.out.println(intArrayList.get(3));
        intArrayList.insert(3, 2);
        intArrayList.print();
    }
}