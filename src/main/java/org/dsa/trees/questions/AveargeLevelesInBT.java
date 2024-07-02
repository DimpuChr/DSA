package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AveargeLevelesInBT {

    public List<Double> aveargeLevelOrder(BinaryTreeLevelOrderTraversal.TreeNode node){
        List<Double> result = new ArrayList<>();
        if(node == null){
            return result;
        }

        // creating a queue and add the root node
        // looping till queue is empty
        //once queue is removed then add the left ad right of that node
        Queue<BinaryTreeLevelOrderTraversal.TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
           double totalSum = 0;
            for (int i = 0; i < levelSize; i++){
                BinaryTreeLevelOrderTraversal.TreeNode currentNode = queue.poll();
                totalSum += currentNode.val;
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(totalSum/levelSize);
        }
        return result;

    }


    public class TreeNode{

        int val;
        BinaryTreeLevelOrderTraversal.TreeNode left;
        BinaryTreeLevelOrderTraversal.TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, BinaryTreeLevelOrderTraversal.TreeNode left, BinaryTreeLevelOrderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
