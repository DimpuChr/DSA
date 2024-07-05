package org.dsa.trees.questions;

public class FlattenBT {

    //faltten bt means we need to convert the Binary tree to Linked list
    // easiest solution is pre order traverse while traversing put thr root to thr queue and move left and right
    //once all traversal done remove queue one by one and make linkedlist
    //the time complexity is O(n) and time complexity is also O(n)
    //without using extraspace we can solve by modiying the actual node
    //the idea is very simple first move to the node left and find the last right ,ost node that has null
    //the add cuurent right to the rightmost node
    //next move current node to cuurent node right

    public void flatten(TreeNode root){

        TreeNode currentNode = root;
        while (currentNode != null){
            if(currentNode.left != null){
                TreeNode temp = currentNode.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }

    // Helper function to print the flattened tree
    public void printFlattenedTree(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }

    public static void main(String[] args) {
        FlattenBT tree = new FlattenBT();

        // Construct the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println("Original tree (in-order):");
        tree.printFlattenedTree(root);

        // Flatten the tree
        tree.flatten(root);

        System.out.println("\nFlattened tree:");
        tree.printFlattenedTree(root);
    }
}
