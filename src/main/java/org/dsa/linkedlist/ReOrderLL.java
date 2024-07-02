package org.dsa.linkedlist;

public class ReOrderLL {

    public static void main(String[] args) {

        //reorder Linked list like below
        //input : 1 -> 2 -> 3-> -> 4 -> 5 -> 6 -> 7
        //output: 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
        // the idea to solve is
        // first find the mid , sort the node after mid
        // next copy one after to the head

        CustomLL ll = new CustomLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        //ll.add(7);
        ll.display();

        ll.reOrder();
        ll.display();
    }
}
