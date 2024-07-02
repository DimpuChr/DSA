package org.dsa.trees;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* CustomBinaryTree tree = new CustomBinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.display();
        System.out.println("::::::::::::::::::::::::::::");*/

        BST bst = new BST();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        bst.populate(nums);
        bst.display();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();

        System.out.println(":::::::::::::::::::::::::::::::");
        System.out.println();

        AVL avl = new AVL();

        for (int i = 0; i < 1000; i++) {
            avl.insert(i);
        }

        System.out.println(avl.height());


    }
}
