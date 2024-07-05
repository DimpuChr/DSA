package org.dsa.trees.questions;

public class InvertBT {

    // invert Binary tree is ver simple
    // use recursion call reach his left and right the swap the nodes

    public TreeNode invertBT(TreeNode root){

        if(root == null){
            return null;
        }

        TreeNode left = invertBT(root.left);
        TreeNode right = invertBT(root.right);

        //once find the left and right just swap and return node
        root.left = right;
        root.right = left;
        return root;
    }

    // Helper function to print the tree (in-order traversal)
    public void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        InvertBT tree = new InvertBT();

        // Construct the tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original tree (in-order):");
        tree.printTree(root);

        // Invert the tree
        TreeNode invertedRoot = tree.invertBT(root);

        System.out.println("\nInverted tree (in-order):");
        tree.printTree(invertedRoot);
    }
}
