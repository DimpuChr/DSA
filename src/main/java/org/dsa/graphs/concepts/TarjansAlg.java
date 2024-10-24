package org.dsa.graphs.concepts;

import java.util.ArrayList;

public class TarjansAlg {

    //Bridge

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        tarjanAlg(graph,V);

    }

    public static void tarjanAlg(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            dfs(graph,i,vis,dt,low,time,-1);
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int current ,boolean[] vis, int[] dt,int[] low, int time, int parent ){

        vis[current] = true;
        dt[current] = low[current] = ++time;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (edge.destination == parent){
                continue;
            } else if (!vis[edge.destination]) {
                //call dfs
                dfs(graph, edge.destination,vis,dt,low,time,current);
                //find lowest discovery time
                low[current] = Math.min(low[current], low[edge.destination]);
                //check it is bridge
                if(low[current] < low[edge.destination]){
                    System.out.println("Bridge is " + current + " ---- " + edge.destination);
                }

            }else {
                //just update the lowest discovery time with comparing discovery time of neighbor (Artical point)

                low[current] = Math.min(low[current], dt[edge.destination]);
            }
        }

    }
}
