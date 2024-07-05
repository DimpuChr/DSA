package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // if we want to prting from back left to right just add 0th index of list

    public List<List<Integer>> levelOrder(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null){
            return result;
        }

        // creating a queue and add the root node
        // looping till queue is empty
        //once queue is removed then add the left ad right of that node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;

    }


    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
