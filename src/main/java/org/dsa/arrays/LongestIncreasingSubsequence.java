package org.dsa.arrays;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    //Given an integer array nums, return the length of the longest strictly increasing
    //subsequence
    //.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [10,9,2,5,3,7,101,18]
    //Output: 4
    //Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    //Example 2:
    //
    //Input: nums = [0,1,0,3,2,3]
    //Output: 4
    //Example 3:
    //
    //Input: nums = [7,7,7,7,7,7,7]
    //Output: 1

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Array to store our increasing subsequence
        int[] lis = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            // Use binary search to find the position to insert the current number
            int position = Arrays.binarySearch(lis, 0, size, num);

            // If the number is not found (i.e., it's negative), binarySearch returns -(insertion point) - 1
            if (position < 0) {
                position = -(position + 1);
            }

            // Insert or replace at the correct position
            lis[position] = num;

            // If position is equal to the current size of the list, we extend the list
            if (position == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + length); // Output: 4
    }
}
