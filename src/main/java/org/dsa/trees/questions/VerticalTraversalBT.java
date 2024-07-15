package org.dsa.trees.questions;

import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalTraversalBT {

    public List<List<Integer>> verticalTraversal(TreeNode node){
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null){
            return answer;
        }
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int col = 0;
        int min =0;
        int max = 0;
        queue.offer(new AbstractMap.SimpleEntry<>(node,col));
        while (!queue.isEmpty()){
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            node = removed.getKey();
            col = removed.getValue();

            if(node != null){
                if(!map.containsKey(col)){
                    map.put(col, new ArrayList<Integer>());
                }
                map.get(col).add(node.val);

                min = Math.min(min,col);
                max = Math.max(max, col);
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1));
            }
        }
        for (int i = min; i <= max ; i++) {
            answer.add(map.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        VerticalTraversalBT traversal = new VerticalTraversalBT();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = traversal.verticalTraversal(root);

        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }
}
