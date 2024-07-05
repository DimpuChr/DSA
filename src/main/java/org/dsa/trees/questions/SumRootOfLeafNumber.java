package org.dsa.trees.questions;

import com.sun.source.tree.Tree;

public class SumRootOfLeafNumber {

    //you are given root of a BT containing digits from 0 to 9 only
    //each root-to-leaf path in the tree represents a number
    // for example the root-to-leaf path 1->2->3 represents the number 123


    public int sumNumbers(TreeNode root){

        //we are using helper method that takes sum as a argument
        return helper(root , 0);
    }

    private int helper(TreeNode root, int sum) {

        if(root == null){
            return 0;
        }
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }
        return (helper(root.left,sum) + helper(root.right,sum));
    }

    public static void main(String[] args) {
        SumRootOfLeafNumber treePathSum = new SumRootOfLeafNumber();

        // Construct an example tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Calculate the sum of all numbers formed by root-to-leaf paths
        int result = treePathSum.sumNumbers(root);
        System.out.println("Sum of all numbers formed by root-to-leaf paths: " + result);
    }
}

