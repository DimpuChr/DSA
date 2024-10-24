package org.dsa.graphs.concepts;

import java.util.ArrayList;

public class WeightedGraph {

    public static void main(String[] args) {

    }

    public static void createGraph(ArrayList<EdgeWeight>[] graph){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new EdgeWeight(0,1,2));
        graph[0].add(new EdgeWeight(0,2,4));

        graph[1].add(new EdgeWeight(1,2,1));
        graph[1].add(new EdgeWeight(1,3,7));

        graph[2].add(new EdgeWeight(2,4,3));

        graph[3].add(new EdgeWeight(3,5,1));

        graph[4].add(new EdgeWeight(4,3,2));
        graph[4].add(new EdgeWeight(4,5,5));

    }

    public static void createGraphForPrimsAlg(ArrayList<EdgeWeight>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new EdgeWeight(0,1,10));
        graph[0].add(new EdgeWeight(0,2,15));
        graph[0].add(new EdgeWeight(0,3,30));

        graph[1].add(new EdgeWeight(1,0,10));
        graph[1].add(new EdgeWeight(1,3,40));

        graph[2].add(new EdgeWeight(2,0,15));
        graph[2].add(new EdgeWeight(2,3,50));

        graph[3].add(new EdgeWeight(3,0,30));
        graph[3].add(new EdgeWeight(3,1,40));
        graph[3].add(new EdgeWeight(3,2,50));

    }



}

class EdgeWeight {

    int source;
    int destination;
    int weight;

    public EdgeWeight(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
