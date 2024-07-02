package org.dsa.stackqueue;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();
        stack.push(12);
        stack.push(13);
        stack.push(16);
        stack.push(22);
        System.out.println(stack.pop());

        CustomStackGeneric<String> stack1 = new CustomStackGeneric<>();
        stack1.push("Darshan");
        stack1.push("Sachin");
        stack1.push("Yuvi");
        stack1.push("Kohli");
        System.out.println(stack1.pop());


        CustomDynamicStack<String> stack2 = new CustomDynamicStack<>();
        stack2.push("Darshan");
        stack2.push("Sachin");
        stack2.push("Yuvi");
        stack2.push("Kohli");
        stack2.push("Kohli");
        stack2.push("Kohli");
        stack2.push("Kohli");
        stack2.push("Sachin");
        stack2.push("Yuvi");
        stack2.push("Kohli");
        stack2.push("Kohli");
        stack2.push("Kohli");
        stack2.push("Kohlwww");
        System.out.println(stack2.pop());
    }
}
