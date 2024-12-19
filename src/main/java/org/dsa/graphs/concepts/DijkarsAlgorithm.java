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

        //initialize distance
        for (int i = 0; i < V; i++) {
                 dist[i] = Integer.MAX_VALUE; // Infinite distance initially
        }
        dist[source] = 0; // Distance to the source is zero
        boolean[] vis = new boolean[V]; // To track visited nodes
        pq.add(new Pair(source,0)); // Add source to the priority queue

        while (!pq.isEmpty()){
            Pair remove = pq.remove();
            int currentNode = remove.node;
            if(!vis[currentNode]){
                vis[currentNode] = true;

                // Relax neighbors
                for (int i = 0; i < graph[currentNode].size(); i++) {
                    EdgeWeight edgeWeight = graph[currentNode].get(i);
                    //int u = edgeWeight.source;
                    int neighbor = edgeWeight.destination;
                    int weight = edgeWeight.weight;
                    //Relaxation
                    if(dist[currentNode] + weight < dist[neighbor]){
                        dist[neighbor] = dist[currentNode] + weight;
                        pq.add(new Pair(neighbor,dist[neighbor]));
                    }
                }
            }

        }

        return dist; // Return the shortest distances


    }

    public  static class Pair implements Comparable<Pair>{
        int node; // Node index
        int distance; // Distance from source

        public Pair(int node, int dest) {
            this.node = node;
            this.distance = dest;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance; // Min-heap based on distance
        }
    }
}


