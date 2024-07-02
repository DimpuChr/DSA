package org.dsa.linkedlist;

public class Main {

    public static void main(String[] args) {

        CustomLL ll = new CustomLL();
        ll.add(12);
        ll.add(23);
        ll.add(43);
        ll.add(21);

        ll.display();
        ll.insertFirst(33);
        ll.insertAtIndex(5,16);
        ll.display();
        ll.insertAtIndex(4,19);
        ll.display();
        ll.deleteNode(3);
        ll.display();
        System.out.println(ll.getSize());
        ll.insertViaRecursion(3,11);
        ll.display();
        System.out.println(ll.getSize());

        System.out.println(".............................................................");
        CustomDLL dll = new CustomDLL();
        dll.insertFirst(12);
        dll.insertFirst(22);
        dll.add(2);
        dll.add(8);
        dll.add(18);
        dll.display();
        dll.insertAt(3,33);
        dll.display();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        CustomCLL cll = new CustomCLL();
        cll.insert(23);
        cll.insert(12);
        cll.insert(32);
        cll.insert(11);
        cll.display();
        cll.delete(32);
        cll.display();

    }
}
