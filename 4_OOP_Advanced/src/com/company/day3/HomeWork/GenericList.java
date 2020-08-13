package com.company.day3.HomeWork;

/**
 * List<T> 제네릭 인터페이스를 구현하여 ArrayList<T> 제네릭을 완성하시오.
 *
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * ArrayList<T>는 Object []를 이용하여 List<T>를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */


interface List<T> {
    void append(T value);
    void prepend(T value);
    void insert(int index, T value);
    void remove(int index);
    T get(int index);
    int length();
}

class ArrayList<T> implements List<T>{
    public Object [] arr;
    public int comp;
    public int idx = 0;
    public ArrayList(int i) {
        System.out.println(i + " 크기 배열 생성");
        comp = i;
        arr = new Object[comp];
    }

    @Override
    public void append(T value) { // List의 마지막에 value를 삽입한다.
        if(idx >= comp){ // 2배로 늘려줘야 함
            extendArr();
        }
        arr[idx] = value;
        idx++;
    }

    @Override
    public void prepend(T value) { // List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
        if(idx >= comp){ // 2배로 늘려줘야 함
            extendArr();
        }
        for(int i=idx; i>=1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        idx++;
    }

    @Override
    public void insert(int index, T value) { // index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
        if(idx >= comp){ // 2배로 늘려줘야 함
            extendArr();
        }
        for(int i=idx; i>index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        idx++;
    }

    @Override
    public void remove(int index) { // index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
        if(idx<0) {
            System.out.println("삭제할 데이터가 없습니다.");
            return;
        }
        for(int i=index; i<comp-1; i++){
            arr[i] = arr[i+1];
        }
        idx--;
    }

    @Override
    public T get(int index) { // index의 value를 반환한다.
        //System.out.println(index + " , " + idx);
        if(index<idx) {
            return (T) arr[index];
        }
        else{
            System.out.println("데이터가 없습니다. 0번 인덱스를 return 합니다.");
            return (T) arr[0];
        }
    }

    @Override
    public int length() { // List의 길이를 출력한다.
        return idx;
    }

    public void extendArr(){
        System.out.println(comp + " -> " + comp*2);
        Object[] temp_arr = new Object[comp*2];
        if (comp >= 0) System.arraycopy(arr, 0, temp_arr, 0, comp);
        arr = temp_arr;
        comp *= 2;
    }
}


public class GenericList {
    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        printList(list);

        list.remove(5);
        printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, 100);
        printList(list);
    }
}
