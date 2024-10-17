package org.dsa.graphs;

import java.util.ArrayList;

public class AllPathFromSourceToTarget {

    //need to print all paths from source to target
    //O(v^v)

    public static void main(String[] args) {

       ArrayList<Edge>[] graph = new ArrayList[7];
       Main.createGraph(graph);
       boolean[] visit = new boolean[7];
       allPath(graph,visit,0,"0",5);

    }

    public static void allPath(ArrayList<Edge>[] graph, boolean[] visit, int current, String path, int target){
        if(current == target){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visit[e.getDestination()]){
                visit[current] = true;
                allPath(graph,visit,e.getDestination(),path + e.getDestination(),target);
                visit[current] = false;
            }
        }
    }

}
