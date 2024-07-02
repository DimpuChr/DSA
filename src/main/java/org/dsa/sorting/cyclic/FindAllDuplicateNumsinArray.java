package org.dsa.sorting.cyclic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicateNumsinArray {
    //Given an array of integers nums containing n+1 integers where each integers in the range [1.n] inclusive
    //There is only one/ more repeated number in nums , return this repeated numbers
    //you must solve the problem without modifying the array nums and use only constant extra space
    //ex: nums [4,3,2,7,8,2,3,1] o/p = [2,3]
    public static void main(String[] args) {

        //int[] arr = {3,0,1};
        int[] arr = {4,3,2,7,8,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                list.add(arr[i]);
            }
        }

        System.out.println(list);

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
}
