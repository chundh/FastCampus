package com.company.day1.AbstractClass;

import java.util.Arrays;

/**
 * AbstractStack
 * -> Stack
 *
 */

abstract class AbstractStack{ // 추상클래스를 만들어서 다양한 종류의 스택을 만들 수 있다.
    protected int capacity;
    protected int top;

    public AbstractStack(int capacity){
        this.capacity = capacity;
        this.top = 0;
    }

    public boolean isEmpty(){
        return this.top==0;
    }

    public abstract void push(int value);
    public abstract int pop();
    public abstract int peek();
}

class ArrayStack extends AbstractStack{ 
    // 추상클래스를 활용하면서 class안에는 class와 관련된 것만(Array) 구현하면서 깔끔한 코드작성을 할 수 있다.
    private int[] array;

    public ArrayStack(int capacity) {
        super(capacity);
        array = new int[capacity];
    }

    @Override
    public void push(int value) {
        array[top++] = value;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return array[--top];
    }

    @Override
    public int peek() {
        return array[top-1];
    }
}

public class AbstractPractice {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);

        for(int i=0; i<10; i++){
            stack.push(i);
        }

        for(int i=0; i<10; i++){
            System.out.println(stack.pop());
        }
    }
}
