package org.dsa.trees.questions;

public class BTFromInorderPostOrder {

    //Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
    // postorder is the postorder traversal of the same tree, construct and return the binary tree.

    private int p;
    public static void main(String[] args) {

    }

    public  TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1; // Start from the end of the postorder array
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null; // Base case: no elements to process
        }

        // The current root is the last element in the current postorder section
        TreeNode root = new TreeNode(postorder[p--]);

        // Find the root in the inorder array
        int index = findIndex(inorder, start, end, root.val);

        // Recursively build the right and left subtrees
        root.right = build(inorder, postorder, index + 1, end); // Build right subtree
        root.left = build(inorder, postorder, start, index - 1); // Build left subtree

        return root;
    }

    private int findIndex(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // This should never happen for a valid input
    }

}
