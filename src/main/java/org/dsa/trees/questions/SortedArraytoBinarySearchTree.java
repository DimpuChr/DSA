package org.dsa.trees.questions;

public class SortedArraytoBinarySearchTree {

    //Given an integer array nums where the elements are sorted in ascending order, convert it to a
    //height-balanced
    // binary search tree.


    //Input: nums = [-10,-3,0,5,9]
    //Output: [0,-3,9,-10,null,5]
    //Explanation: [0,-10,5,null,-3,null,9] is also accepted:

    public static void main(String[] args) {

        SortedArraytoBinarySearchTree bst = new SortedArraytoBinarySearchTree();
        int[] nums = {-10,-3,0,5,9};
        bst.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        TreeNode head = helper(nums,0,nums.length-1);
        return head;
    }

    public TreeNode helper(int[] nums , int start, int end ){

        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,start,mid-1);
        node.right = helper(nums,mid+1,end);
        return node;
    }
}
