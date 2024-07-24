package org.dsa.trees.questions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public static List<String> binaryTreePaths(TreeNode root){

        List<String> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
         binaryTreePaths(root , "", answer);
        return answer;

    }

    public static void binaryTreePaths(TreeNode root , String path , List<String> answer){

        if(root.left == null && root.right == null){
             answer.add(path + root.val);
        }
        if(root.left != null){
            binaryTreePaths(root.left, path + root.val + "->", answer);
        }
        if(root.right != null){
            binaryTreePaths(root.right, path + root.val + "->", answer);
        }

    }


    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));


    }
}
