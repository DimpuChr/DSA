package org.dsa.recursion.maze;

public class MazeAllPath {

    //Backtracking is a general algorithmic technique used to solve problems recursively by building a solution incrementally,
    // one piece at a time, and removing solutions that fail to satisfy the constraints of the problem at any point in time.
    // In the context of a maze, backtracking involves exploring all possible paths from the start to the destination,
    // and backtracking if a path leads to a dead end or doesn't lead to the destination.

    public static void main(String[] args) {

        boolean[][]  maze = {{true,true,true},
                {true,true,true},
                {true,true,true}};
        findAllPaths(0,0,maze,"");

    }

    static void findAllPaths(int row, int col , boolean[][] maze, String procseed){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(procseed);
            return;
        }

        if(!maze[row][col]){
            return;
        }
        //considering this block in my path
        // so marking as visited
        maze[row][col] = false;

        if(row < maze.length-1){
            findAllPaths(row+1,col,maze,procseed + 'D');
        }
        if(col < maze[0].length-1){
            findAllPaths(row,col+1,maze,procseed + 'R');
        }

        if(row > 0){
            findAllPaths(row-1,col,maze,procseed + 'U');
        }
        if(col > 0){
            findAllPaths(row,col-1,maze,procseed + 'L');
        }

        //this where function will over
        //so before the function get removed. also remove the changes that were made by that function
        maze[row][col] = true;
    }
}
