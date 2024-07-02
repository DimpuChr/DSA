package org.dsa.linkedlist;

public class CustomDLL {

    private Node head;

    public void insertFirst(int value) {

        Node node = new Node(value);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void add (int value){
        Node node = new Node(value);
        if(head == null){
            insertFirst(value);
            return;
        }
        Node temp = head;
        while (temp.next !=null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void insertAt(int index, int value){

        Node temp = getIndex(index-1);
        System.out.println(temp.value);
        Node node = new Node(value);
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
    }

    public Node getIndex(int index){
        Node temp = head;
        for (int i = 1; i <= index ; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");

    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}
