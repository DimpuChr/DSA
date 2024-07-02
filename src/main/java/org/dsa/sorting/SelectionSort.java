package org.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        // selection sort is simple sorting technique
        //first take any max value the keep that into its correct indexes
        // ar last doing all n-1 steps the array will be sorted
        // the time complexity of this sorting algorithm in worst cast and best case is O(N2)

        int[] arr = {4,5,1,2,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int [] arr){

        for (int i = 0; i < arr.length ; i++) {
            int start = 0;
            int last = arr.length -i -1;
            int maxIndex = maxIndex(arr,start,last);
            swap(arr,maxIndex,last);
        }

    }

    static int maxIndex(int[] arr , int start , int end ){
        int max = start;
        for (int i = start; i <= end ; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr , int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
