package org.dsa.graphs.concepts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArticulationPoint {

    //find articulation point using Tarjan's Algorithm

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        //initialize all index
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //create graph
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));

        tarjansAlg(graph,V);

    }

    public static void tarjansAlg(ArrayList<Edge>[] graph , int V){

        //O(V+E)

        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,time,vis,ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if(ap[i]){
                System.out.println("Articulation point is " + i);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int current, int parent, int[] dt,int[] low, int time, boolean[] vis, boolean[]ap ){

        vis[current] = true;
        dt[current] = low[current] = ++time;
        int child = 0;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            int neighbor = e.destination;

            if(neighbor == parent){
                continue;
            } else if (vis[neighbor]) {
                low[current] = Math.min(low[current], dt[neighbor]);
            }else {
                dfs(graph,neighbor,current,dt,low,time,vis,ap);
                low[current] = Math.min(low[current], low[neighbor]);
                if(dt[current] <= low[neighbor] && parent != -1){
                    ap[current] = true;
                }
                child++;
            }
        }

        if(parent == -1 && child > 1){
            ap[current] = true;
        }
    }
}
