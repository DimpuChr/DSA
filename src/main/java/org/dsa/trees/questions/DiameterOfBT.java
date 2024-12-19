package org.dsa.trees.questions;

import org.dsa.trees.basics.BinaryTreeConstruct;

public class DiameterOfBT {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
        height(root);
        return diameter -1;
    }

    int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);
        int dia = left + right +1;
        diameter = Math.max(diameter,dia);
        return Math.max(left,right) + 1;
    }

    public TreeInfo diameterOfTreeApproach2(BinaryTreeConstruct.Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameterOfTreeApproach2(root.left);
        TreeInfo right = diameterOfTreeApproach2(root.right);

        int maxheight = Math.max(left.height,right.height) + 1;

        int dia1 = left.diameter;
        int dia2 = right.diameter;
        int dia3 = left.height + right.height + 1;

        int mydia = Math.max(Math.max(dia1,dia2),dia3);
        return new TreeInfo(maxheight,mydia);

    }
    public class TreeInfo{
        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

}

