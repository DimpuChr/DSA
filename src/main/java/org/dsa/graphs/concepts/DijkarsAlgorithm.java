package org.dsa.graphs.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkarsAlgorithm {


    public static void main(String[] args) {
        ArrayList<EdgeWeight>[] graph = new ArrayList[6];
        WeightedGraph.createGraph(graph);
        System.out.println(Arrays.toString(shortestPath(graph,0,6)));


    }

    public static int[] shortestPath(ArrayList<EdgeWeight>[] graph, int source, int V){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
             if(i != source){
                 dist[i] = Integer.MAX_VALUE;
             }
        }
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()){
            Pair remove = pq.remove();
            if(!vis[remove.node]){
                vis[remove.node] = true;

                for (int i = 0; i < graph[remove.node].size(); i++) {
                    EdgeWeight edgeWeight = graph[remove.node].get(i);
                    int u = edgeWeight.source;
                    int v = edgeWeight.destination;
                    //Relaxation
                    if(dist[u] + edgeWeight.weight < dist[v]){
                        dist[v] = dist[u] + edgeWeight.weight;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }

        }

        return dist;


    }

    public  static class Pair implements Comparable<Pair>{
        int node;
        int dest;

        public Pair(int node, int dest) {
            this.node = node;
            this.dest = dest;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dest - p2.dest;
        }
    }
}


