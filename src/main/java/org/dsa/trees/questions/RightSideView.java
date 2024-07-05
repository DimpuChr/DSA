package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    // imagine you are standing on right of the tree
    // print all right side of the tree
    // just use BFS/ level traversal
    // add last elment in the list

     public List<Integer> rightSideView(TreeNode root){
         List<Integer> result = new ArrayList<>();
         if(root == null){
             return result;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         int levelSize = queue.size();
         // traverse till my queue empty
         while (!queue .isEmpty()){
             for (int i = 0; i < levelSize; i++) {
                 TreeNode current = queue.poll();
                 if(i == levelSize-1){
                     result.add(current.val);
                 }
                 if(current.left != null){
                     queue.offer(current.left);
                 }
                 if(current.right !=null){
                     queue.offer(current.right);
                 }
             }
         }
         return result;
     }

}
