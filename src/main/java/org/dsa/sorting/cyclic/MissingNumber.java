package org.dsa.sorting.cyclic;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {

        //int[] arr = {3,0,1};
        int[] arr = {9,6,4,2,3,5,7,0,1};
        sort(arr, 9);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i){
                System.out.println(i);
                break;
            }
        }

    }
    static void sort(int[] arr, int num){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] ;
            if(correctIndex < num && arr[i] != arr[correctIndex]){
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
