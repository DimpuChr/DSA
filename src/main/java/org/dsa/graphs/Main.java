package org.dsa.graphs;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

        System.out.println("bfs..............");
        bfs(graph,7);
        System.out.println("dfs......................");
        boolean[] visit = new boolean[7];
        dfs(graph,0,visit);

    }
    public static void createGraph(ArrayList<Edge> [] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    //Breadth First Search
    //BFS is print the node and move to his neighbours print all his neighbours and move
    //3 ponits to remember
    // create queue and run through queue
    //create one boolean array to check visit node
    // remove from queue and add to queue of his neihbours
    //O(V+E)
    public static void bfs(ArrayList<Edge>[] list, int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[v];
        queue.add(0);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if(visit[poll] == false){
                System.out.print(poll + " ");
                visit[poll] = true;
                for (int i =0 ; i < list[poll].size(); i++){
                    Edge e = list[poll].get(i);
                    queue.add(e.getDestination());
                }
            }
        }
        System.out.println(" ");
    }

    public static void dfs(ArrayList<Edge>[] graph , int current, boolean[] visit){

        System.out.print(current + " ");
        visit[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visit[e.destination])
              dfs(graph, e.getDestination(),visit);
        }
    }
}

class Edge{
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
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
}

