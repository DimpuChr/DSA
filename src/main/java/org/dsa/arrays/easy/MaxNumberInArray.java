package org.dsa.arrays.easy;

public class MaxNumberInArray {

    // need to find the maximum number that present an array
    //ex : [6,2,34,12,32,16] -> 34 is the max

    public static void main(String[] args) {

        int[] arr = {6,2,34,12,32,16};
        int max = Integer.MIN_VALUE;
        for (int number : arr){
            if(number > max){
                max = number;
            }
        }
        System.out.println(" max number in array " + max);

        // to find minimum value in array
        int min = Integer.MAX_VALUE;
        for (int number : arr){
            if(number < min){
                min = number;
            }
        }
        System.out.println(" min number in array " + min);
    }

}
