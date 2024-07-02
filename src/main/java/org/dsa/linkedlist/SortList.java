package org.dsa.linkedlist;

public class SortList {

    public static void main(String[] args) {

        CustomLL l1 = new CustomLL();
        l1.add(1);
        l1.add(4);
        l1.add(2);
        l1.add(5);
        l1.mergeSort(l1);

        l1.display();

    }
}
