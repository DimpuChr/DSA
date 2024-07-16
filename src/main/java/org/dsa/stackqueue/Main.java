package org.dsa.stackqueue;

import org.dsa.stackqueue.basics.CustomDynamicStack;
import org.dsa.stackqueue.basics.CustomQueue;
import org.dsa.stackqueue.basics.CustomStack;
import org.dsa.stackqueue.basics.CustomStackGeneric;

public class Main {

    public static void main(String[] args) throws Exception {

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

        System.out.println("::::::::::::::::::::Queue::::::::::::::");
        CustomQueue queue = new CustomQueue();
        queue.insert(12);
        queue.insert(24);
        queue.insert(74);
        queue.insert(15);
        queue.insert(36);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
