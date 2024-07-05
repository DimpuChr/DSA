package org.dsa.trees.questions;

import com.sun.source.tree.Tree;

public class CousinisInBT {

    // need to find the cousin means that has in the same level of tree and not have same parents
    //idea is first find the both nodes
    //check the level and check for not siblings
    public boolean isCousin(TreeNode root, int x , int y){

        TreeNode xx = findNode(root , x );
        TreeNode yy = findNode(root,y);

        return (level(root , xx, 0) == level (root , yy, 0)) && !isSibling (root , xx,yy);
    }

    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy) {

        if(node == null){
            return  false;
        }
        return ((node.left == xx && node.right == yy) || (node.left == yy && node.right == xx)) || isSibling(node.left,xx,yy) || isSibling(node.right,xx,yy);

    }

    private int level(TreeNode node, TreeNode xx, int level) {
        if( node == null){
            return 0;
        }
        if(node == xx){
            return level;
        }
        int l = level(node.left , xx , level +1);
        if(l != 0){
            return l;
        }
        return level(node.right,xx, level+1);

    }

    private TreeNode findNode(TreeNode node, int value) {

        if(node == null){
            return  null;
        }
        if(node.val == value){
            return node;
        }
        TreeNode left = findNode(node.left,value);
        if(left != null){
            return  left;
        }
        return findNode(node.right,value);
    }


}



