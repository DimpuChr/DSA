package org.dsa.trees.questions;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    //symmetric tree : root of binary tree given check whether it is a mirror of itself


    public boolean isMirror(TreeNode node){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node.left);
        queue.offer(node.right);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right ==null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;

    }
}
