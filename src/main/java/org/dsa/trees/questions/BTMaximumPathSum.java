package org.dsa.trees.questions;

public class BTMaximumPathSum {

    // a path BT is a sequence of nodes where each pair of adjacent nodes in the sequence has the edge connecting them


    // Holds the maximum path sum found so far
    int answer = Integer.MIN_VALUE;

    // Public method to start the max path sum calculation
    public int maxPathSum(TreeNode root){
        helper(root);
        return answer;
    }

    // Helper method to compute the max path sum including the current node
    private int helper(TreeNode root) {

        if(root == null){
            return 0;
        }
        // Recursively compute the maximum path sums for the left and right subtrees
        int left = helper(root.left);
        int right = helper(root.right);

        // If the maximum path sum of the left or right subtree is negative, ignore it
        left = Math.max(0,left);
        right = Math.max(0,right);

        // Compute the path sum through the current node
        int pathSum = left + right + root.val;

        // Update the answer if the current path sum is greater than the previously recorded maximum
        answer = Math.max(answer, pathSum);

        // Return the maximum path sum including the current node and one of its subtrees (left or right)
        return Math.max(left,right) + root.val;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the Solution class
        BTMaximumPathSum solution = new BTMaximumPathSum();

        // Calculate and print the maximum path sum
        int result = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result); // Output should be 11
    }
}
