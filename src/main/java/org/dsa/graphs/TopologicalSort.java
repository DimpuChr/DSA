package org.dsa.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    //DFS-based Approach
    //This approach involves performing a Depth-First Search (DFS) and using a stack to store the result.
    // When a vertex finishes (i.e., when all its descendants are visited), it is pushed onto the stack.
    //
    //Steps:
    //Perform a DFS on the graph.
    //On DFS completion of a node, push it onto a stack.
    //Reverse the stack to get the topological sort.

    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,0));
        graph[1].add(new Edge(1, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        Main.createGraph(graph);
        topSort(graph,6);

    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int current, boolean[] vis, Stack<Integer> stack){
        vis[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!vis[current]){
                topSortUtil(graph,e.getDestination(),vis,stack);
            }
        }
        stack.push(current);
    }

    public static void topSort(ArrayList<Edge>[] graph,int length){
        boolean[] vis = new boolean[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if(!vis[i]){
                topSortUtil(graph,i,vis,stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }


    }
}
