package org.dsa.sliding;

import java.util.HashMap;

public class MaximumSumSubArrayDistinct {

    //You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
    //
    //The length of the subarray is k, and
    //All the elements of the subarray are distinct.
    //Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
    //
    //A subarray is a contiguous non-empty sequence of elements within an array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,5,4,2,9,9,9], k = 3
    //Output: 15
    //Explanation: The subarrays of nums with length 3 are:
    //- [1,5,4] which meets the requirements and has a sum of 10.
    //- [5,4,2] which meets the requirements and has a sum of 11.
    //- [4,2,9] which meets the requirements and has a sum of 15.
    //- [2,9,9] which does not meet the requirements because the element 9 is repeated.
    //- [9,9,9] which does not meet the requirements because the element 9 is repeated.
    //We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        //int[] arr = {4,4,4};
        System.out.println(maximumSubarraySum(arr,3));
    }
    static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = 0;
        int wSum = 0;
        for (int i = 0; i < nums.length; i++) {
            wSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                if (map.size() == k) {
                    maxSum = Math.max(wSum, maxSum);
                }
                wSum -= nums[i - k + 1];
                map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);
                if (map.get(nums[i - k + 1]) == 0) {
                    map.remove(nums[i - k + 1]);
                }
            }
        }
        return maxSum;
    }

}
