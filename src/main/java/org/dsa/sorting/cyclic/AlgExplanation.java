package org.dsa.sorting.cyclic;

import java.util.Arrays;

public class AlgExplanation {
    public static void main(String[] args) {

        // when given number range from 1 to N then use cyclic sort
        // means suppose 1 to 5 means [3,5,2,1,4]
        // above the numbers from 1 to 5 and they jumbled

        int [] arr = {3,5,2,1,4};
        sort1(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {

            while (arr[i] != i+1){
                int value = arr[i];
                int correctIndex = arr[i] -1;
                swap(arr,i,correctIndex);
            }

        }

    }

    static void sort1(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] -1 ;
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
