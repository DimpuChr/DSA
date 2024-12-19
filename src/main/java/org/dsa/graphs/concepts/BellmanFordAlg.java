package org.dsa.graphs.concepts;

import java.util.ArrayList;

public class BellmanFordAlg {

    public static void main(String[] args) {

    }

    public static void findShortestPath(ArrayList<EdgeWeight>[] graph, int source, int V){
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            if(i != source){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        distance[source] = 0; // Distance to the source is 0

        // Outer loop for V-1 iterations (Relax all edges V-1 times)
        for (int i = 0; i < V-1; i++) {

            // Traverse all edges
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    EdgeWeight edgeWeight = graph[j].get(k);
                    int u = edgeWeight.getSource();
                    int v = edgeWeight.destination;

                    //relaxation code
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + edgeWeight.weight < distance[v]){
                        distance[v] = distance[u] + edgeWeight.weight;
                    }
                }
            }

        }
        // Optional: Check for negative weight cycles
        for (int j = 0; j < V; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                EdgeWeight edgeWeight = graph[j].get(k);
                int u = edgeWeight.getSource();
                int v = edgeWeight.getDestination();
                int weight = edgeWeight.getWeight();

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return;
                }
            }
        }
    }
}
