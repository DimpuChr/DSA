package org.dsa.sorting.cyclic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllNumberDisappearInArray {

    //Fin all the numbers disappear in an Array
    // Given an array nums of n integer where nums[i] is in the range [1,n] return an array of all the
    // integers in the range [1,n] that do not appear in nums
    // ex: i/p nums = [4,3,2,7,8,2,3,1] o/p = [5,6]

    public static void main(String[] args) {

        int[] arr = {4,3,2,7,8,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                list.add(i+1);
            }
        }
        System.out.println(list);

    }
    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] -1 ;
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
