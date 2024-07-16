package org.dsa.trees.questions;

public class KthSmallestElementBST2 {

    private int k;
    private int ans;

    public int findKthElement(TreeNode root , int k){
        this.k = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if(root == null){
            return;
        }
        // Traverse the left subtree
        helper(root.left);
        // Decrement k and check if current node is the k-th smallest
        k--;
        if(k==0){
            ans = root.val;
            return;
        }
        // Traverse the right subtree
        helper(root.right);
    }


    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Find the k-th smallest element
        KthSmallestElementBST2 finder = new KthSmallestElementBST2();
        int k = 3;
        int result = finder.findKthElement(root, k);
        System.out.println("The " + k + "-th smallest element in the BST is: " + result);
    }
}
