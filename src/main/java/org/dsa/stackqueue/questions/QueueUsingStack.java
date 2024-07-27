package org.dsa.stackqueue.questions;

import java.util.Stack;

public class QueueUsingStack {

    //implement FIFO queue using only two stacks
    //the implemented queue should support all the functions of a normal queue

    public static void main(String[] args) {

        QueueUsingStack stack = new QueueUsingStack();
        stack.add(12);
        stack.add(32);
        stack.add(45);
        System.out.println(stack.remove());
    }

    private Stack<Integer> first;

    private Stack<Integer> second;

    public QueueUsingStack() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void add(int value){
        first.push(value);
    }

    public int remove(){

        while (!first.isEmpty()){
            second.push(first.pop());
        }

        int removed = second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    public int peek(){

        while (!first.isEmpty()){
            second.push(first.pop());
        }

        int peek = second.peek();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return peek;
    }
}
