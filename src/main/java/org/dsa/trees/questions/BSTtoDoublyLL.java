package org.dsa.trees.questions;

public class BSTtoDoublyLL {

    Node head;
    Node tail;

    public Node convertToDLL(TreeNode root){
        if(root == null){
            return null;
        }
        helper(root);
        return head;
    }

    private void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);
        Node node = new Node(root.val);
        if(head == null){
            head = node;
            tail = node;
        } else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        helper(root.right);
    }


    class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
}
