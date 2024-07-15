package org.dsa.sorting;

import java.util.Arrays;

public class CountSort {

    // it works for smaller numbers
    //the idea is first find the maximum number in an array
    //create a new array with maximum number size
    // next iterate the original array and find the frequency of each element
    // then add to the old array

    public static void main(String[] args) {

        int[] arr = {6,3,10,9,2,4,9,7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void countSort(int[] arr) {
        int max = arr[0];

        //find the maximum element
        for (int num : arr){
            if(num > max){
                max = num;
            }
        }

        int[] counntArray = new int[max+1];
        for (int num : arr){
            counntArray[num]++;   // Increment the count for each number
        }

        int index = 0;
        for (int i = 0; i < max; i++) {
            while (counntArray[i] > 0){
                arr[index] = i;
                index++;
                counntArray[i]--;
            }
        }

    }

}
