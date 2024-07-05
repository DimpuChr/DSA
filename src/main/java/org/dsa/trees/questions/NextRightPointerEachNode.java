package org.dsa.trees.questions;

public class NextRightPointerEachNode {

    //you are given a perfect BT , where all leafs are in the same level and every parents has two childrens
    //populate each next pointer to point to its next right node
    // If there is no next right node, the next pointer should set to null
    //initially all next pointer are set to null
    //[1,2,3,4,5,6,7] => [1,#,2,3,#,4,5,6,7,#]


    public TreeNode nextRightPointer(TreeNode root){
        TreeNode leftMostNode = root;
        while (leftMostNode.left != null){
            TreeNode current = leftMostNode;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.right;
                }
                current = current.next;
            }
            leftMostNode = leftMostNode.left;
        }
        return root;
    }

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
