package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderSuccessor {
//level order successor means return thr next value in the level
    public TreeNode levelOrderSuccessor(TreeNode node, int value){

        if(node == null){
            return node;
        }

        // creating a queue and add the root node
        // looping till queue is empty
        //once queue is removed then add the left ad right of that node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            boolean valueFound = false;
            for (int i = 0; i < levelSize; i++){
               TreeNode currentNode = queue.poll();
                if(currentNode.val == value){
                    valueFound = true;
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
                if(valueFound){
                    break;  // Break out of the loop if value is found
                }
            }
            // next successor
            if(valueFound){
                return queue.poll();  // Return the next node in the queue
            }
        }
        return null; // Return null if the value is not found

    }

    public TreeNode levelOrderSuccessor1(TreeNode node, int value){

        if(node == null){
            return null;
        }

        // creating a queue and add the root node
        // looping till queue is empty
        //once queue is removed then add the left ad right of that node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
                if(currentNode.val == value){
                    break;  // Break out of the loop if value is found
                }
        }
        return queue.peek(); // Return node if the value is not found

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

        public TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
