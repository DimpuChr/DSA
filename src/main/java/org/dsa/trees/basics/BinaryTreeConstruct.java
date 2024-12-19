package org.dsa.trees.basics;

import java.util.*;

public class BinaryTreeConstruct {
    int idx = -1 ;


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreeConstruct bst = new BinaryTreeConstruct();
        Node node = bst.buildTree(nodes);
        //System.out.println(node.data);
        //preOrder(node);
        //inOrder(node);
        //postOrder(node);
        //levelOrder(node);
        //nodeCount(node);
        //System.out.println(nodeCountRecu(node));
        //System.out.println(sumOfNode(node));
        //System.out.println(heightOfTree(node));
        //System.out.println(diameterOfTree(node));
        //TreeInfo treeInfo = bst.diameterOfTreeApproach2(node);
        //System.out.println(treeInfo.diameter);
        //sumOfNodeNthLevel(node,4);
        //System.out.println(kthLargestLevelSum(node,3));

        ArrayList<Integer> list = new ArrayList<>();
        roottoLeafNode(node,list);


    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);

    }

    public static void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                System.out.print(curNode.data+ " ");
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }

            }
            System.out.println();
        }
    }
    public static void nodeCount(Node node){
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                count++;
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }

            }
        }
        System.out.println(count);

    }
    public static int  nodeCountRecu(Node node){
        if(node == null){
            return 0;
        }

        int left = nodeCountRecu(node.left);
        int right = nodeCountRecu(node.right);
        return left + right +1;
    }

    public static int  sumOfNode(Node root){
        if(root == null){
            return 0;
        }

        int left = sumOfNode(root.left);
        int right = sumOfNode(root.right);
        return left + right + root.data;
    }

    public static int  heightOfTree(Node root){
        if(root == null){
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left,right) + 1;
    }

    //O(n2)
    public static int  diameterOfTree(Node root){
        if(root == null){
            return 0;
        }

        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);
        int height = heightOfTree(root.left) + heightOfTree(root.right) +1;
        return Math.max(height,Math.max(left,right));
    }

    public  TreeInfo  diameterOfTreeApproach2(Node root){
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

    public static void sumOfNodeNthLevel(Node root, int k){
        if(k == 0){
            System.out.println(-1);
            return;
        }
        int count = 0;
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            level = level+1;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if(level == k){
                    count = count + poll.data;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }

        System.out.println(count);
        System.out.println("level is " + level);


    }
    public static long kthLargestLevelSum(Node root, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;  // Reset level sum at the start of each level

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                levelSum += current.data;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            list.add(levelSum);
        }

        Collections.sort(list,Collections.reverseOrder());
        if(k > list.size()){
            return -1;
        }else{
            return list.get(k-1);
        }

    }
    public static void printinRange(int x , int y, Node root){
        if(root == null){
            return;
        }

        if(root.data >= x && root.data <= y ){
            printinRange(x,y,root.left);
            System.out.println(root.data + " ");
            printinRange(x,y,root.right);
        } else if (root.data >= y) {
            printinRange(x,y,root.left);
        }else {
            printinRange(x,y,root.right);
        }
    }

    public static void roottoLeafNode(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.left == null && root.right == null){
            rootPath(list);
        }else {
            roottoLeafNode(root.left,list);
            roottoLeafNode(root.right,list);
        }
        list.remove(list.size()-1);
    }
    public static void rootPath(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ->");
        }
        System.out.println();
    }

    public class TreeInfo{
        public int height;
        public int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }



    public class Node{
        int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public  Node buildTree(int[] nodes){
        idx ++;
        if(nodes[idx] == -1){
            return null;
        }
        Node node = new Node(nodes[idx]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}
