package org.dsa.graphs.concepts;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlg {

    public static void main(String[] args) {
        int V =4;
        ArrayList<EdgeWeight>[] graph = new ArrayList[V];
        WeightedGraph.createGraphForPrimsAlg(graph);
        System.out.println(findMST(graph,0,V));

    }

    public static int findMST(ArrayList<EdgeWeight>[] graph, int source, int V){

        PriorityQueue<Pair> pq = new PriorityQueue<>();//non mst
        pq.add(new Pair(source,0));
        boolean[] vis = new boolean[V];//mst
        int mostCost = 0;
        while (!pq.isEmpty()){
            Pair current = pq.remove();
            if(!vis[current.node]){
                vis[current.node] = true;
                mostCost += current.cost;
                for (int i = 0; i < graph[current.node].size(); i++) {
                    EdgeWeight edgeWeight = graph[current.node].get(i);
                    if(!vis[edgeWeight.destination]){
                        pq.add(new Pair(edgeWeight.destination, edgeWeight.weight));
                    }
                }
                
            }
        }
        return mostCost;


    }


}

class Pair implements Comparable<Pair>{
    int node;
    int cost;

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
        return this.cost-o.cost;
    }
}


