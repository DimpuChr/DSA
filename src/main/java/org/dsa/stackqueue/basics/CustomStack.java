package org.dsa.stackqueue.basics;

public class CustomStack {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int pointer = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int value){

       if(isFull()){
           throw new RuntimeException("stack is full ");
       }
       pointer ++;
       data[pointer] = value;
       return  true;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("cannot pop from empty stack");
        }
        return data[pointer--];
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("cannot peek from empty stack");
        }
        return data[pointer];
    }

    private boolean isFull() {
        return pointer == data.length - 1;
    }

    private boolean isEmpty(){
        return pointer == -1;
    }
}
