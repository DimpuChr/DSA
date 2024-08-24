package org.dsa.trees.questions;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {

    //Given the root of a complete binary tree, return the number of the nodes in the tree.
    //
    //According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    //
    //Design an algorithm that runs in less than O(n) time complexity.
    //Input: root = [1,2,3,4,5,6]
    //Output: 6


    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        count++;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i =0; i < levelSize;i++){
                TreeNode current = queue.poll();
                if(current.left!= null){
                    queue.offer(current.left);
                    count++;
                }
                if(current.right!= null){
                    queue.offer(current.right);
                    count++;
                }
            }
        }
        return count;

    }

    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
            //(2<<leftHeight) - 1; // 2^leftHeight - 1
        } else {
            return 1 + countNodes1(root.left) + countNodes1(root.right); // 1 for the current node
        }
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
