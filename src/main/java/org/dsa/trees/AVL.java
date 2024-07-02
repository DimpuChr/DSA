package org.dsa.trees;

public class AVL {

    //AVL or self Balancing tree means
    //For every node in the tree , the differ in height of left and right of subtree of that node is must be lest than or equal to 1 (<=1)

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

    public AVL() {
    }

    public int height(){
        return height(root);
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
        node.height = Math.max(height(node.left), height(node.right) + 1);
        return rotate(node);
    }

    //rotate function is rotate the unbalanced tree
    public Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            //left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // left left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // left rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1){
            //right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // right right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right rotate
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        //update the height

        p.height = Math.max(height(p.left),height(p.right) + 1 ) ;
        c.height = Math.max(height(c.left),height(c.right) + 1)  ;

        //return the c
        return c;
    }

    public Node leftRotate(Node c){

        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        //update the height
        p.height = Math.max(height(p.left),height(p.right) + 1) ;
        c.height = Math.max(height(c.left),height(c.right) + 1)  ;

        //return the c
        return p;

    }

    // If the node to be deleted has:
    //No children (leaf node): Simply remove it.
    //One child: Replace it with its child.
    //Two children: Replace it with its in-order successor (or predecessor), and recursively delete the successor (or predecessor).
    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Node to be deleted found
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.value = mostLeftChild.value;
                node.right = delete(node.right, node.value);
            }
        }

        if (node != null) {
            node.height = Math.max(height(node.left), height(node.right) + 1);
            node = rotate(node);
        }

        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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
