package org.dsa.trees.questions;

import java.util.HashMap;
import java.util.Map;



public class BinaryTreeFromTraversals {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        // Create a map to get the index of each value in inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Call the recursive function with initial parameters
        return buildTreeRecursive(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Get the root index in inorder traversal
        int rootIndex = inorderIndexMap.get(rootValue);

        // Number of elements in the left subtree
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively construct the left subtree
        root.left = buildTreeRecursive(preorder, preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1);
        // Recursively construct the right subtree
        root.right = buildTreeRecursive(preorder, preStart + leftSubtreeSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }

    // Helper function to print the tree (inorder traversal)
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Helper function to print the tree (preorder traversal)
    public void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromTraversals treeBuilder = new BinaryTreeFromTraversals();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed tree:");
        treeBuilder.printInOrder(root);
        System.out.println("\nPreorder traversal of constructed tree:");
        treeBuilder.printPreOrder(root);
    }
}

