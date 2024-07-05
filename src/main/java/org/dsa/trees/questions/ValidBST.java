package org.dsa.trees.questions;

public class ValidBST {

    // need to validate the provided tree has valid Binary Search Tree
    //approach is like we need to compare each node if it is left side it must less than parent node and in right side it should be graeter than parent node
    //use rescursion and used some helper values
    // using preorder approach
    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if(node == null){
            return true;
        }
        if(low !=null && node.val <= low){
            return false;
        }
        if(high != null && node.val >= high){
            return false;
        }
        boolean leftTree = helper(node.left , low , node.val);
        boolean rightTee = helper(node.right , node.val, high);

        //return if both are true
        return leftTree && rightTee;
    }


    //test function

    public static void main(String[] args) {
        ValidBST test = new ValidBST();
        test.runTests();
    }

    public void runTests() {
        // Test 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        assert isValidBST(root1) : "Test 1 Failed";

        // Test 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        assert !isValidBST(root2) : "Test 2 Failed";

        // Test 3: Valid BST with negative values
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(-3);
        root3.right = new TreeNode(9);
        root3.left.left = new TreeNode(-10);
        root3.left.right = new TreeNode(-2);
        assert isValidBST(root3) : "Test 3 Failed";

        // Test 4: Single node tree
        TreeNode root4 = new TreeNode(1);
        assert isValidBST(root4) : "Test 4 Failed";

        // Test 5: Empty tree (null root)
        TreeNode root5 = null;
        assert isValidBST(root5) : "Test 5 Failed";

        System.out.println("All tests passed!");
    }
}
