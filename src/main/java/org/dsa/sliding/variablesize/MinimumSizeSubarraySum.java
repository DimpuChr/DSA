package org.dsa.sliding.variablesize;

public class MinimumSizeSubarraySum {

    //Given an array of positive integers nums and a positive integer target, return the minimal length of a
    //subarray
    // whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
    //
    //
    //
    //Example 1:
    //
    //Input: target = 7, nums = [2,3,1,2,4,3]
    //Output: 2
    //Explanation: The subarray [4,3] has the minimal length under the problem constraint.
    //Example 2:
    //
    //Input: target = 4, nums = [1,4,4]
    //Output: 1


    public static void main(String[] args) {
        int[] arr ={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));


    }

    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int wsum = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            wsum += nums[right];
            while (wsum >= target) {
                min = Math.min(min, right - left + 1);
                wsum -= nums[left];
                left++;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
