package org.dsa.sorting.cyclic;

import java.util.Arrays;

public class FirstMissingPositive {
    //level : HARD
    //Given an unsorted integer array nums , return the smallest missing positive integer
    //You must implement an algorithm that runs in o(n) time and uses constant extra space
    //ex: nums[1,2,0] o/p 3
    //when seeing this no where giving 1 to n to apply cyclic sort
    //if we carefully observe the answer we need to return is the smallest positive integer that is missing
    //ex: [7,8,9,11,12] after sort [7,8,9,11,12] it sorted only
    //now the answer is the 1 because that is the smallest positive number missing
    //we need to start from 1 and keep on checking weather it exist or not if not just return the smallest missing number
    public static void main(String[] args) {

        int[] arr = {3,4,-1,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                System.out.println(i+1);
                break;
            }
        }

    }
    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1 ;
            if(arr[i] > 0 && correctIndex <= arr.length && arr[i] != arr[correctIndex]){
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
