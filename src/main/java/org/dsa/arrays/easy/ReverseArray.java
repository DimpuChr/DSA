package org.dsa.arrays.easy;

import java.util.Arrays;

public class ReverseArray {

    // Need to reverse array ex: [1,2,5,3,22,18] -> [18,22,3,5,2,1]
    // the below approach is using two pointer
    // first pointer is at start of array and second pointer is and end of array , next will swap these two
    // next increment start pointer and decrement the end pointer
    //run the loop till start exceeds end

    public static void main(String[] args) {

        int[] arr = {1,2,5,3,22,18};
        System.out.println("Before revere " + Arrays.toString(arr));
        int start = 0;
        int end = arr.length-1;
        while(start < end ){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("After revere " + Arrays.toString(arr));
    }


}
