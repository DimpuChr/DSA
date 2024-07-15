package org.dsa.trees.questions;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {

    //Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
    //Input: root = [5,3,6,2,4,null,7], k = 9
    //Output: true

    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if(root == null){
            return false;
        }
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return helper(root.left,k,set) || helper(root.right,k,set);
    }

    public static void main(String[] args) {
        // Example BST: [5, 3, 6, 2, 4, null, 7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        TwoSumIV sum = new TwoSumIV();
        boolean result = sum.findTarget(root, k);
        System.out.println("Does the BST contain two elements that add up to " + k + "? " + result); // Output: true
    }
}
