package org.dsa.trees.questions;

public class MaxDepthOfBT {

    //A binary trres maximum depth is the number of nodes along the longest path from root node down to the leaf node

    public int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = Math.max(left,right) + 1;
        return depth;
    }

    // Helper function to print the tree (in-order traversal)
    public void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        MaxDepthOfBT tree = new MaxDepthOfBT();

        // Construct the tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Tree (in-order):");
        tree.printTree(root);

        // Calculate and print the maximum depth of the tree
        int depth = tree.maxDepth(root);
        System.out.println("\nMaximum depth of the tree: " + depth);
    }
}
