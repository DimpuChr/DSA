package org.dsa.trees.questions;

public class findPathBT {

    // need to find the provided path exist in the tree
    //if exist return true else return false
    //determine if there is a root-to-leaf path in a binary tree that matches a given sequence of values

    public boolean findPath(TreeNode node, int[] arr){
        // Entry point to start the path finding
        if(node == null){
            return false;
        }
        return helper(node , arr ,0);
    }

    // Helper method to recursively find the path
    private boolean helper(TreeNode node, int[] arr, int index) {

        // Base cases
        if(node == null){
            return false;
        }
        if(index >= arr.length || node.val != arr[index]){
            return false;
        }
        if(node.left == null && node.right == null && index == arr.length-1){
            return true;
        }
        // Recursively check left and right subtrees
        return helper(node.left ,arr , index+1) || helper(node.right ,arr, index+1);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the Solution class
        findPathBT solution = new findPathBT();

        // Define the sequence to find
        int[] arr1 = {1, 2, 5};
        int[] arr2 = {1, 3};

        // Test and print results
        System.out.println("Path {1, 2, 5} exists: " + solution.findPath(root, arr1)); // Output should be true
        System.out.println("Path {1, 3} exists: " + solution.findPath(root, arr2));   // Output should be true
        System.out.println("Path {1, 2, 3} exists: " + solution.findPath(root, new int[]{1, 2, 3})); // Output should be false
    }
}
