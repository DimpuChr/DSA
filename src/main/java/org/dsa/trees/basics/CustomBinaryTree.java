package org.dsa.trees.basics;

import java.util.Scanner;

public class CustomBinaryTree {

    private Node root;

    private class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public CustomBinaryTree() {

    }

    public void populate (Scanner scanner){
        System.out.println("Enter the root node value");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    public void populate (Scanner scanner, Node node){
        System.out.println("Do you want to insert to left node of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the left value for the node " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to insert to Right node of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the right value for the node " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
}
