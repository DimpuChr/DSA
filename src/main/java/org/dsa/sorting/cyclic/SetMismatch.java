package org.dsa.sorting.cyclic;

import java.util.Arrays;

public class SetMismatch {
    //You have a set of integers s, which oriinally contains all the numbers from 1 to n.
    //unfortunately due to some error , one of the number got duplicated to the another number in set ,
    //which results repetition of one number and loss of another number
    //Find the number that occur twice and the number that is missing and return them in the form of array
    public static void main(String[] args) {

        //int[] arr = {3,0,1};
        int[] arr = {1,2,2,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                System.out.println(Arrays.toString(new int[]{arr[i],i+1}));
            }
        }

    }
    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1 ;
            if( arr[i] != arr[correctIndex]){
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
