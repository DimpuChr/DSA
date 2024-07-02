package org.dsa.arrays.easy;

public class MaximumWealth {

    //given an grid of m * n  integer grid where account[i][j] is the amount of money the ith customer has in the jth account return the wealth that the richest customer has

    public static void main(String[] args) {

        int[][] arr = {{1,2,3},{3,2,1},{4,5,6}};
        int totalRowCount = 0;
        int maxWealth = Integer.MIN_VALUE;

        for (int[] row : arr){
            for (int col : row){
                totalRowCount += col;
            }
            if(totalRowCount > maxWealth){
                maxWealth = totalRowCount;
            }
            totalRowCount = 0;
        }

        System.out.println("max wealth is: "+ maxWealth);
    }
}
