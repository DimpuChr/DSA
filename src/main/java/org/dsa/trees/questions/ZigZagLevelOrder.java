package org.dsa.trees.questions;

import java.util.*;

public class ZigZagLevelOrder {


    //zig zag level order means we need to print in zig zag manner
    //it is normal to level order traverse but we need to use deque here
    //because we need to poll from last for reversal
    //just maintain one boolean variable
    // if it normal remove from front and add in to back of queue
    // if it reverse poll from last and then add to front
    public List<List<Integer>> zigZagLevelOrder(BinaryTreeLevelOrderTraversal.TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null){
            return result;  // Return an empty list if the root node is null
        }

        // creating a queue and add the root node
        // looping till queue is empty
        //once queue is removed then add the left ad right of that node
        Deque<BinaryTreeLevelOrderTraversal.TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean reverse = false;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++){
                if(!reverse){
                    BinaryTreeLevelOrderTraversal.TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null){
                        queue.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offerLast(currentNode.right);
                    }
                }
                else{
                    BinaryTreeLevelOrderTraversal.TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right != null){
                        queue.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.offerFirst(currentNode.left);
                    }
                }

            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;

    }
}

