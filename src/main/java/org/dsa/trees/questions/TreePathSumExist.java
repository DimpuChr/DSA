package org.dsa.trees.questions;


//pathsum we need to return if the totalsum exist from root to leaf node then return true or return false

public class TreePathSumExist {

    public boolean hasPath(TreeNode node , int totalSum){

        //if node is null return false
        if(node == null){
            return false;
        }
        // Check if we reach a leaf node and if its value equals remaining totalSum
        if(node.val == totalSum && node.left ==null && node.right == null){
            return true;
        }
        // Recursively check left and right subtrees
        return hasPath(node.left, totalSum - node.val) || hasPath(node.right, totalSum- node.val);
    }


    public static void main(String[] args) {
        TreePathSumExist treePathSum = new TreePathSumExist();

        // Example tree construction
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        System.out.println("Does the tree have a path sum equal to " + targetSum + " ? " + treePathSum.hasPath(root, targetSum));
    }

}
