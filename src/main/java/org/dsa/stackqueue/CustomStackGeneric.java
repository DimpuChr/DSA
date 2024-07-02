package org.dsa.stackqueue;

public class CustomStackGeneric<T> {

    public T[] data;
    private static final int DEFAULT_SIZE = 10;

    int pointer = -1;

    public CustomStackGeneric() {
        this(DEFAULT_SIZE);
    }
    public CustomStackGeneric(int size) {
        this.data = (T[]) new Object[size];
    }

    public boolean push(T value){

        if(isFull()){
            throw new RuntimeException("stack is full ");
        }
        pointer ++;
        data[pointer] = value;
        return  true;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("cannot pop from empty stack");
        }
        return data[pointer--];
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("cannot peek from empty stack");
        }
        return data[pointer];
    }

    public boolean isFull() {
        return pointer == data.length - 1;
    }

    private boolean isEmpty(){
        return pointer == -1;
    }
}
