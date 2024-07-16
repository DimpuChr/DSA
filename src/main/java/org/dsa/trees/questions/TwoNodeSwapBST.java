package org.dsa.trees.questions;

public class TwoNodeSwapBST {

    // two nodes swapped in the bst

    // Two nodes that have been swapped in the BST
    TreeNode first;
    TreeNode second;
    TreeNode prev;


    public void swapTwoNodes(TreeNode root){
        // Initialize the variables
        first = null;
        second = null;
        prev = null;

        // Perform in-order traversal to find the two swapped nodes
        iot(root);

        // Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void iot(TreeNode root) {
        if(root == null){
            return;
        }
        // Traverse the left subtree
        iot(root.left);
        // Find the first and second nodes that are out of order
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        // Traverse the right subtree
        iot(root.right);
    }

    public static void main(String[] args) {
        // Create a BST with two nodes swapped
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2); // The nodes 2 and 4 are swapped

        // Print the BST before fixing
        System.out.println("BST before fixing:");
        printInOrder(root);

        // Fix the swapped nodes
        TwoNodeSwapBST fixer = new TwoNodeSwapBST();
        fixer.swapTwoNodes(root);

        // Print the BST after fixing
        System.out.println("BST after fixing:");
        printInOrder(root);
    }

    // Helper method to print the BST in in-order traversal
    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
