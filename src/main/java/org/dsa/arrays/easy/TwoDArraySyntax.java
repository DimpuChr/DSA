package org.dsa.arrays.easy;

public class TwoDArraySyntax {

    //2 D Array

    public static void main(String[] args) {

        int[][] arr = {
                       {1,2,3},
                       {8,3,5},
                       {8,12,4}
                      };

        // iterate using for each
        for(int[] row : arr){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        //check num exist or not
        System.out.println(checkNumExist(arr,12));

    }

    static int checkNumExist(int[][] arr, int target){

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    System.out.println("row number is "+ row + " column num is "+ col);
                    return row;
                }
            }
        }

        return -1;
    }
}
