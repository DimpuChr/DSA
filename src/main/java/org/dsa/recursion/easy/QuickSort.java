package org.dsa.recursion.easy;

import java.util.Arrays;

public class QuickSort {

    //take any number as pivot and swap all the elements lower to pivot to left and greater than pivot to right
    //in first pass the pivot will be at correct place
    //finally the array will be sorted

    public static void main(String[] args) {

        int[] arr = {5,4,2,3,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] nums, int low , int hi){

        if(low >= hi){
            return;
        }

        int start = low;
        int end = hi;
        int mid = start + (end-start)/2;
        int pivot = nums[mid];

        while (start <= end){

            while(nums[start] < pivot){
                start++;
            }
            while (nums[end] > pivot){
                end--;
            }
            if (start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(nums,low, end);
        quickSort(nums,start,hi);

    }
}
