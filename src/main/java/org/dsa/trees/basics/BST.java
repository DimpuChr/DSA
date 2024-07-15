package org.dsa.trees.basics;

public class BST {

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BST() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public void insert(int value){
        root = insert(root,value);

    }

    private  Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(node.left,value);
        }
       if(value > node.value){
           node.right = insert(node.right,value);
       }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;

    }

    public void display(){

        display(this.root, " Root node : ");
    }
    public void display(Node node , String details){

        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left , " Left child of " + node.value + " : ");
        display(node.right , " Right child of " + node.value + " : ");
    }

    public boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value +" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value +" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value +" ");
    }
}
