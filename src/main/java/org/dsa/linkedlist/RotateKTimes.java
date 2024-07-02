package org.dsa.linkedlist;

public class RotateKTimes {

    //rotate the LL by K times
    // approach is simple
    // first calculate the length
    // traverse prev to that node
    // assign last node to head
    // prev next element to null

    public static void main(String[] args) {

        CustomLL ll = new CustomLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.display();
        ll.rotateKTimes(8);
        ll.display();
    }
}
