package org.dsa.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    // Directions for 8 movements: top-left, top, top-right, right, bottom-right, bottom, bottom-left, left
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {1, 1}, {1, 0},
            {1, -1}, {0, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end points are blocked, no path exists
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // BFS setup
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // Starting point
        grid[0][0] = 1; // Mark as visited with the path length

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            int distance = grid[row][col];

            // If we reached the bottom-right corner, return the path length
            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            // Explore all 8 possible directions
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the move is valid and the cell is unvisited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = distance + 1; // Mark as visited and store distance
                }
            }
        }

        // If BFS completes without reaching the target, no path exists
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix spbm = new ShortestPathBinaryMatrix();

        // Test case 1
        int[][] grid1 = {{0, 1}, {1, 0}};
        System.out.println(spbm.shortestPathBinaryMatrix(grid1)); // Output: 2

        // Test case 2
        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(spbm.shortestPathBinaryMatrix(grid2)); // Output: 4

        // Test case 3
        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(spbm.shortestPathBinaryMatrix(grid3)); // Output: -1
    }
}
