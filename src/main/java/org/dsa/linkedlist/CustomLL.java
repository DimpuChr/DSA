package org.dsa.linkedlist;

public class CustomLL {

    private Node head;
    private Node tail;
    private int size;

    public CustomLL() {
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public void add(int  value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        tail = temp.next;
        size += 1;
    }

    public void insertFirst(int value){

        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            size+=1;
            return;
        }
        node.next = head;
        head = node;
        size+=1;
    }

    public void display(){
        Node temp = head ;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertAtIndex(int index, int value){

        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            add(value);
            return;
        }
        Node temp = getNode(index-1);
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size+=1;

    }

    public void deleteNode(int index){
        if(index == 0){
            deleteAtFirst();
            return;
        }
        if(index == size){
            deleteLast();
            return;
        }
        Node node = getNode(index-1);
        node.next = node.next.next;
        size -=1;
    }

    private void deleteAtFirst(){
        Node node = head;
        head = node.next;
        node.next =null;
        size -=1;
    }

    private void deleteLast(){
        Node node = getNode(size-2);
        tail = node;
        node.next = null;
        size -= 1;
    }

    public Node getNode(int index){
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void insertViaRecursion(int index, int value){
        head = callRecur(index,value,head);

    }

    private Node callRecur(int index , int value , Node node){

        if(index == 0){
            Node temp = new Node(value,node);
            /*Node temp = new Node(value);
            temp.next = node;*/
            size++;
            return temp;
        }
        node.next = callRecur(index-1, value,node.next);
        return node;
    }


    //method is to remove the duplicates from sorted list

    public void removeDuplicates(){
        Node slow = head;
        Node fast = head.next;

        while (fast != null){
            if(slow.value == fast.value){
                slow.next = fast.next;
            } else{
                slow = slow.next;
            }
            fast = fast.next;
        }
    }

    public void removeDuplicates1(){
        Node node = head;
        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            } else{
                node = node.next;
            }
        }
    }

    public CustomLL mergeTwoSortedList(CustomLL ll1, CustomLL ll2){
        Node first = ll1.head;
        Node second = ll2.head;
        CustomLL answer = new CustomLL();
        while (first != null && second != null){
            if(first.value < second.value){
                answer.add(first.value);
                first = first.next;
            } else{
                answer.add(second.value);
                second = second.next;
            }
        }

        //after one of the list null check for remaing and add all the value as it is because lists are sorted

        while (first != null){
            answer.add(first.value);
            first = first.next;
        }

        while (second != null){
            answer.add(second.value);
            second = second.next;
        }

        return answer;
    }

    // find the middle of the node
    public int  findmiddleNodeNum(){
        Node first = head;
        Node second = head;

        while (second !=null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        return first.value;
    }

    public Node  findmiddleNode(){
        Node first = head;
        Node second = head;

        while (second !=null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    // call sortList
    public Node mergeSort(CustomLL ll){
        return sortList(ll.head);
    }

    // sort linked list using
    public Node sortList(Node head){
        Node node = head;
        if(head == null || head.next ==null){
            return head;
        }
        Node mid = findmiddleNode();
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeTwoSortedListNode(left,right);

    }

    public Node mergeTwoSortedListNode(Node list1 , Node list2){

        Node dummyHead = new Node();
        Node tail = dummyHead;
        while (list1 != null && list2 !=null){

            if(list1.value < list2.value){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;

    }

    public void reverseCLL(){
        reverse(head);
    }

    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;

    }

    public void inPlaceReverse(){

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }

    public Node inPlaceReverseReturnNode(Node head){

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }


    //Given the head of LL and two integers left and right where left <= right ,
    //reverse the nodes of the list from position left ro position right and return the reverse list

    public void inPlaceReverse2(int left , int right){

        Node current = head;
        Node prev = null;
        for (int i = 0; current !=null && i < left-1; i++) {
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node lastEnd = current;

        Node next = current.next;

        // just reverse the ll fron left to right
        for (int i = 0; current != null && i < (right-left) +1; i++) {

            current.next = prev;
            prev= current;
            current = next;
            if(next !=null){
                next = next.next;
            }
        }

        // the revese is completed need to assign the next
        if(last != null){
            last.next  = prev;
        } else{
            head = prev;
        }

        lastEnd.next = current;

    }

    //palindrome or not
    public boolean checkPalindrome(){

        Node mid = findmiddleNode();
        Node prev = null;
        Node current = mid;
        Node next = current.next;

        while (current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next!= null){
                next = next.next;
            }
        }

        Node node = head;
      /*  while (node !=null && prev !=null){
                if(node.value != prev.value){
                    break;
                }
                node = node.next;
                prev = prev.next;
        }
        return node == null || prev == null;*/

        while (prev != null){
            if(node.value != prev.value){
                return false;
            }
            node = node.next;
            prev = prev.next;
        }
        return true;
    }

    //Re order

    public void reOrder(){

        if(head == null || head.next == null){
            return;
        }

        Node mid = findmiddleNode();

        Node hs = inPlaceReverseReturnNode(mid);
        Node hf = head;

        while (hf != null && hs != null){

            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if(hf != null){
            hf.next = null;
        }
    }

    public void rotateKTimes(int k){
        Node node = head;
        int length = 1;
        while (node.next != null){
            node = node.next;
            length +=1;
        }

        //assign last node to head
        node.next = head;
        int rotationCount = k % length;
        int rotation = length - rotationCount;

        Node temp = head;
        for (int i = 0; i < rotation-1; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
    }

    public void reverseKTimes(int k){
        Node current = head;
        Node prev = null;

        while (true){
            Node last = prev;
            Node lastEnd = current;

            Node next = current.next;

            // just reverse the ll fron left to right
            for (int i = 0; current != null && i < k; i++) {

                current.next = prev;
                prev= current;
                current = next;
                if(next !=null){
                    next = next.next;
                }
            }

            // the revese is completed need to assign the next
            if(last != null){
                last.next  = prev;
            } else{
                head = prev;
            }


            lastEnd.next = current;
            if(current == null){
                break;
            }
            prev = lastEnd;
        }

    }



    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

    }
    
}
