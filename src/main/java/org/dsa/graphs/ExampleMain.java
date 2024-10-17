package org.dsa.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleMain {

    public static void main(String[] args) {

        ArrayList<Edge> graph[] = new ArrayList[7];
        Main.createGraph(graph);
        boolean[] visited = new boolean[7];
        printAllPath(graph,0,visited,"0",5);



    }

    public static void printAllPath(ArrayList<Edge> graph[], int curr, boolean[] visited, String path, int target){
        if(curr == target){
            System.out.print(path+ " ");
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                visited[curr] = true;
                printAllPath(graph,e.destination,visited,path + e.destination,target);
                visited[curr] = false;
            }
        }

    }
}
