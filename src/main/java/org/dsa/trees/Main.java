package org.dsa.trees;

import org.dsa.trees.basics.AVL;
import org.dsa.trees.basics.BST;
import org.dsa.trees.heaps.HeapsCustom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        List<Integer> list1 = new ArrayList<>();
        list1.add(22);
        list1.add(33);
        answer.add(list);
        answer.add(list1);
        System.out.println(answer);
        List<List<Integer>> answer1 = new ArrayList<>();
        for (int i = answer.size()-1; i >=0; i--) {
            answer1.add(answer.get(i));
        }
        System.out.println(answer1);


    }
   /* public static void main(String[] args) throws Exception {

       *//* CustomBinaryTree tree = new CustomBinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.display();
        System.out.println("::::::::::::::::::::::::::::");*//*

        *//*BST bst = new BST();
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
*//*

        try {
            HeapsCustom<Integer> heap = new HeapsCustom<>();
            heap.insert(3);
            heap.insert(1);
            heap.insert(6);
            heap.insert(5);
            heap.insert(2);
            heap.insert(4);

            System.out.println("Heap after inserts: " + heap.list);

            System.out.println("Sorted elements: " + heap.heapSort());


                List<Integer> unsortedList = List.of(3, 1, 6, 5, 2, 4);
                HeapsCustom<Integer> heap1 = new HeapsCustom<>(unsortedList);

                System.out.println("Heap after building from unsorted list: " + heap1.list);
                System.out.println();

                System.out.println("Sorted elements: " + heap1.heapSort());

                String s= "darshanrameshkunal";
                s.contains("ramesh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/




}
