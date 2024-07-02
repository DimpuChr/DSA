package org.dsa.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacle {

    // we have maze in that we have one obstacle s we can not go that way
    // need to avoid that path

    public static void main(String[] args) {

        boolean[][]  maze = {{true,true,true},
                {true,false,true},
                {true,true,true}};
        pathObstacle(0,0,maze,"");
        System.out.println(pathObstacleList(0,0,maze,""));
    }

    static void pathObstacle(int row, int col , boolean[][] maze, String procseed){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(procseed);
            return;
        }

        if(!maze[row][col]){
            return;
        }

        if(row < maze.length-1){
            pathObstacle(row+1,col,maze,procseed + 'D');
        }
        if(col < maze[0].length-1){
            pathObstacle(row,col+1,maze,procseed + 'R');
        }
    }

    static List<String> pathObstacleList(int row, int col , boolean[][] maze, String procseed){
        if(row == maze.length-1 && col == maze[0].length-1){
            List<String > list = new ArrayList<>();
            list.add(procseed);
            return list;
        }

        List<String > list = new ArrayList<>();
        if(!maze[row][col]){
            return list;
        }
        if(row < maze.length-1){
            list.addAll(pathObstacleList(row+1,col,maze,procseed + 'D'));
        }
        if(col < maze[0].length-1){
            list.addAll(pathObstacleList(row,col+1,maze,procseed + 'R'));
        }

        return list;
    }
}
