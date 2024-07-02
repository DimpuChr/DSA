package org.dsa.linkedlist;

public class MergeTwoSortedList {

    //we have two sorted linked list we need to merge these two
    // let's say first = [1,2,4] and second = [1,3,4,9,12]
    // the answer would be [1,1,2,3,4,4,9,12]
    public static void main(String[] args) {

        CustomLL list1 = new CustomLL();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.display();
        CustomLL list2 = new CustomLL();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        list2.add(9);
        list2.add(12);
        list2.display();

        CustomLL answer = new CustomLL();
        CustomLL customLL = answer.mergeTwoSortedList(list1, list2);
        customLL.display();

    }
}
