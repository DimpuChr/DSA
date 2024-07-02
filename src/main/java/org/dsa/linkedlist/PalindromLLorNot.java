package org.dsa.linkedlist;

public class PalindromLLorNot {

    public static void main(String[] args) {

        CustomLL ll = new CustomLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        System.out.println(ll.checkPalindrome());



    }
}
