package org.dsa.trees.questions;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {

    // Binary Serach tree need to find the kth smalllest element
    // we know if you use in order the BST will give sorted values
    // easiest approach do traverse inorder (LNR) ,  while travesring after left add node values to list
    //return the kth element from list
    // another approach is traverse till last of the tree and increment the values like counter if counter return the value
    //return that node

    int count = 0;
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k){
        return helper(root,k).val;
    }

    public TreeNode helper(TreeNode node, int k){

        if(node == null ){
            return null;
        }
        // Search in left subtree
        TreeNode left = helper(node.left, k);
        if(left != null){
            return left; // If found in left subtree, return it
        }
        // Increment count and check if current node is the k-th smallest
        count++;
        if(count == k){
            return node; // Current node is the k-th smallest
        };
        // Search in right subtree
        return helper(node.right, k);
    }

    public void helperInorder(TreeNode node, int k){

        if(node == null){
            return;
        }
        helperInorder(node.left,k);
        list.add(node.val);
        helperInorder(node.right,k);
    }
    public static void main(String[] args) {
        // Construct the binary search tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        KthSmallestElementBST bst = new KthSmallestElementBST();
        int k = 6;
        System.out.println("The " + k + "rd smallest element is " + bst.kthSmallest(root, k));
        bst.helperInorder(root,k);
        System.out.println(bst.list);
        System.out.println(bst.list.get(k-1));
    }
}
