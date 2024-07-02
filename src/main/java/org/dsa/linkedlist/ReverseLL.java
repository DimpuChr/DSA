package org.dsa.linkedlist;

public class ReverseLL {

    public static void main(String[] args) {

        CustomLL ll = new CustomLL();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);

        ll.display();

        ll.reverseCLL();
        ll.display();


    }
}
