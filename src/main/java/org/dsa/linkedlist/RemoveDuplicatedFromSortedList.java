package org.dsa.linkedlist;

public class RemoveDuplicatedFromSortedList {

    //delete all duplicates such that each element appears only once.
    // return linked list in sorted as well
    // need to remove the duplicates from the sorted list
    //lets say the lis contains [1,1,2] -> [1,2] or [1,1,2,3,3] -> [1,2,3]
    // as we se above we are  removing duplicate numbers


    public static void main(String[] args) {
        CustomLL ll = new CustomLL();
        ll.add(1);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);
        ll.add(4);
        ll.display();

        ll.removeDuplicates1();
        ll.display();
    }

}
