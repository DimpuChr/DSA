package org.dsa.sorting.cyclic;

import java.util.Arrays;

public class FinTheDuplicateNum {

    //Given an array of integers nums containing n+1 integers where each integers in the range [1.n] inclusive
    //There is only one repeated number in nums , return this repeated order
    //you must solve the problem without modifying the array nums and use only constant extra space
    //ex: nums [1,3,4,2,2] o/p = 2
    public static void main(String[] args) {

        //int[] arr = {3,0,1};
        int[] arr = {3,1,3,4,2};
        //findDuplicate(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                System.out.println(arr[i]);
                break;
            }
        }

    }
    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1 ;
            if(correctIndex < arr.length && arr[i] != arr[correctIndex]){
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

    public static int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int num = Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0)
            {
                return num;
            }

            nums[idx]=-nums[idx];
        }
        return -1;
    }
}
