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

        //outer loop for v-1 times
        for (int i = 0; i < V-1; i++) {

            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    EdgeWeight edgeWeight = graph[j].get(i);
                    int u = edgeWeight.getSource();
                    int v = edgeWeight.destination;

                    //relaxation code
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + edgeWeight.weight < distance[v]){
                        distance[v] = distance[u] + edgeWeight.weight;
                    }
                }
            }

        }
    }
}
