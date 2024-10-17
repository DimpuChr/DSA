package org.dsa.graphs;

import java.util.ArrayList;

public class CycleExist {
    // to find cycle exist in Directed graph
    //Directed graph means the vertex as direction towards the edges
    //approach using DFS
    // same as dfs and additionally need to add one more boolean array to track the exist vertex in the array or not if yes return true
    //while returning make sure need to false the boolean array (track array)

    public static void main(String[] args) {

        ArrayList<Edge> [] graph = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(1, 0));
        graph[1].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

        System.out.println(isCycleExist(graph, new boolean[4],0,new boolean[4]));

    }

    public static boolean isCycleExist(ArrayList<Edge>[] graph, boolean[] visit, int current, boolean[] stack){
        visit[current] = true;
        stack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(stack[e.getDestination()]){
                return true;
            } else if (!visit[e.getDestination()] && isCycleExist(graph,visit,e.getDestination(),stack)) {
                return true;
            }
        }
        stack[current] = false;
        return false;
    }

}
