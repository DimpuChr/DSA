package org.dsa.trees.questions;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class BTFromPreorderInorder {


    //preorder is root -> left -> right
    //inorder left -> root -> right
    //iF WE OBSERVE CAREFULLY preorder root is first
    // next find the same root in the inorder by traversing
    //after call recursive method for preorder left is index 1 till the index of inorder plus1
    // in order right is start from 0 till index
    public TreeNode construct( int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == r){
                index = i;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = construct(Arrays.copyOfRange(preorder, 1, index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = construct(Arrays.copyOfRange(preorder, index+1, preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
}
