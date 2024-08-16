package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    //Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
    //
    //BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
    //boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    //int next() Moves the pointer to the right, then returns the number at the pointer.
    //Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
    //
    //You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
    //Input
    //["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    //[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
    //Output
    //[null, 3, 7, true, 9, true, 15, true, 20, false]
    //
    //Explanation
    //BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
    //bSTIterator.next();    // return 3
    //bSTIterator.next();    // return 7
    //bSTIterator.hasNext(); // return True
    //bSTIterator.next();    // return 9
    //bSTIterator.hasNext(); // return True
    //bSTIterator.next();    // return 15
    //bSTIterator.hasNext(); // return True
    //bSTIterator.next();    // return 20
    //bSTIterator.hasNext(); // return False

    List<Integer> list = new ArrayList<>();
    int i =0;
    public BSTIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        this.list = list;
    }

    public int next() {
        if( i < list.size()){
            return list.get(i++);
        }
        return 0;

    }

    public boolean hasNext() {
        if(i < list.size()){
            Integer integer = list.get(i);
            if(integer != null){
                return true;
            }
            return false;
        }
        return false;

    }
    private  void inOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return ;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right,list);
    }


      public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
             this.right = right;
         }
      }

    public static void main(String[] args) {




    }
    public void build(){
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

    }
}
