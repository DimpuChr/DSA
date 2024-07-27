package org.dsa.sliding;

import java.util.ArrayList;
import java.util.List;

public class SlidingSubarrayBeauty {
    //https://leetcode.com/problems/sliding-subarray-beauty/description/

    //Given an integer array nums containing n integers, find the beauty of each subarray of size k.
    //
    //The beauty of a subarray is the xth smallest integer in the subarray if it is negative, or 0 if there are fewer than x negative integers.
    //
    //Return an integer array containing n - k + 1 integers, which denote the beauty of the subarrays in order from the first index in the array.
    //
    //A subarray is a contiguous non-empty sequence of elements within an array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
    //Output: [-1,-2,-2]
    //Explanation: There are 3 subarrays with size k = 3.
    //The first subarray is [1, -1, -3] and the 2nd smallest negative integer is -1.
    //The second subarray is [-1, -3, -2] and the 2nd smallest negative integer is -2.
    //The third subarray is [-3, -2, 3] and the 2nd smallest negative integer is -2.

    public static void main(String[] args) {
        int[] arr = {1,-1,-3,-2,3};
        System.out.println(getSubarrayBeauty(arr,3,2));
    }
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int maxSum = 0;
        int wSum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            wSum += nums[i];
            list.add(nums[i]);
            if(i >= k){
                wSum = wSum - nums[i-k+1];

                list.remove(nums[i-k+1]);

            }
        }
        return null;

    }
}
