package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.List;

public class SameTree {

    //Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    //
    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
    printInOrder(p,list1);
    List<Integer> list2 = new ArrayList<>();
    printInOrder(q,list2);
        return list1.equals(list2);

}

    public  static void printInOrder(TreeNode node, List<Integer> list){
        if(node == null){
            return ;
        }
        list.add(node.val);
        printInOrder(node.left,list);
        printInOrder(node.right,list);
    }

    public  static boolean isSameTreeOptiomize(TreeNode p, TreeNode q){
        if(p == null && q== null){
            return true;
        }
        if(p== null || q == null || p.val != q.val){
            return false;
        }
        return isSameTreeOptiomize(p.left,q.left) &&isSameTreeOptiomize(p.right,q.right);
    }
}
