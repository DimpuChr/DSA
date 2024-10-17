package org.dsa.graphs;

import java.util.ArrayList;

public class CycleExistUnDirected {

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        System.out.println(isCycleExist(graph, new boolean[4],0,-1));

    }

    public static boolean isCycleExist(ArrayList<Edge> graph[], boolean[] vis, int current, int parent){

        vis[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(vis[e.destination] == true && parent != e.destination){
                return true;
            }else if (!vis[e.destination]){
                if(isCycleExist(graph,vis,e.destination,current)){
                    return true;
                }
            }
        }
        return false;
    }
}
