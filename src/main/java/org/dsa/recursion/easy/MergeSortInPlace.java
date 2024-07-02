package org.dsa.recursion.easy;

import java.util.Arrays;

public class MergeSortInPlace {

    //Divide the array two parts
    //get both part sorted via recursion
    //merge two part

    public static void main(String[] args) {

        int[] arr = {3,4,12,5,6,34,56};
        sortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }


    static void sortInPlace(int[] arr, int start, int end){

        if(end-start <= 1){
            return ;
        }
        int mid = start+(end-start)/2;
        // Recursively sort the left half
        sortInPlace(arr,0,mid);
        // Recursively sort the right half
        sortInPlace(arr,mid,end);
        // Merge the sorted halves
        mergeInPlace(arr,start,end , mid);
    }

    // Method to merge two sorted subarrays in place
    private static void mergeInPlace(int[] arr , int start,int end , int mid){
        int[] mix = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;
        // Merge the two halves into the mix array
        while (i < mid && j < end){
            if(arr[i] < arr[j] ){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements from the left half
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        // Copy any remaining elements from the right half
        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        // Copy the sorted elements back into the original array
        System.arraycopy(mix, 0, arr, start + 0, mix.length);
        /*for (int ii = 0; ii < mix.length; ii++) {
            arr[start + ii] = mix[ii];
        }*/
    }
}
