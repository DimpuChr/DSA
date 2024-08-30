package org.dsa.graphs;

import java.util.ArrayList;

public class AllPathFromSourceToTarget {

    //need to print all paths from source to target
    //O(v^v)

    public static void main(String[] args) {

       ArrayList<Edge>[] graph = new ArrayList[7];
       Main.createGraph(graph);
       Main.bfs(graph,7);


    }

}
