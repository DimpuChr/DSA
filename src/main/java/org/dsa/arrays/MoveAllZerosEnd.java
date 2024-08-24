package org.dsa.arrays;

import java.util.Arrays;

public class MoveAllZerosEnd {

    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //
    //Note that you must do this in-place without making a copy of the array.

    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Example 2:
    //
    //Input: nums = [0]
    //Output: [0]

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int end = i+1;
            while (nums[start] == 0 && end < nums.length){
                if(nums[end] != 0){
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
                end++;
            }
            start++;
        }

    }

    public static void moveZeroes1(int[] nums) {

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] !=0){
                nums[start++] = nums[i];
            }
        }
        for (int i = start; i < nums.length; i++) {
            nums[i] =0;
        }

    }
}
