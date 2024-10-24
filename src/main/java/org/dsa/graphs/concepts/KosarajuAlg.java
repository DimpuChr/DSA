package org.dsa.graphs.concepts;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlg {

    public static void main(String[] args) {

        //time complexity O(V+E)
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        Main.createGraphKosrajuAlg(graph);
        kosarajuAlg(graph,V);
    }

    public  static void topSort(ArrayList<Edge>[] graph, int current , boolean[] vis, Stack<Integer> stack){
        vis[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!vis[edge.destination]){
                topSort(graph, edge.destination,vis,stack);
            }
        }
        stack.push(current);
    }

    public static void dfs(ArrayList<Edge>[] graph, int current, boolean[] vis){
        vis[current] = true;
        System.out.print(current + " ");

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!vis[edge.destination]){
                dfs(graph, edge.destination,vis);
            }
        }
    }

    public static void kosarajuAlg(ArrayList<Edge>[] graph , int V){

        //step 1 O(V+E)
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topSort(graph,i,vis,stack);
            }
        }

        //step 2  O(V+E)

        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge edge = graph[i].get(j);
                transpose[edge.destination].add(new Edge(edge.destination, edge.source));
            }
        }

        //step 3; O(V+E)
        while (!stack.isEmpty()){
            Integer current = stack.pop();
            if(!vis[current]){
                dfs(transpose,current,vis);
            }
            System.out.println();
        }
    }
}
