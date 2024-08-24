package org.dsa.trees.questions;

public class NextRightPointerEachNodeII {
    //Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    //
    //Initially, all next pointers are set to NULL.


    public static void main(String[] args) {
        NextRightPointerEachNodeII ss = new NextRightPointerEachNodeII();
        ss.build();
    }
    public void build (){
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.right = new Node(7);

        nextRightPointer(node);
    }

    public Node nextRightPointer(Node root) {
        if (root == null) return null;

        Node currentLevel = root;  // Start from the root

        while (currentLevel != null) {
            Node dummy = new Node(0);  // Dummy node to start connections at each level
            Node prev = dummy;  // Pointer to keep track of the last connected node at the current level

            // Traverse the current level
            Node current = currentLevel;
            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;  // Move prev to the last connected node
                }
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;  // Move prev to the last connected node
                }
                current = current.next;  // Move to the next node in the current level
            }

            // Move to the next level
            currentLevel = dummy.next;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
