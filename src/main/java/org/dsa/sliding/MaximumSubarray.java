package org.dsa.sliding;

public class MaximumSubarray {

    //Given an integer array nums, find the
    //subarray
    // with the largest sum, and return its sum.
    //Example 1:
    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //Output: 6
    //Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    //Example 2:

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    static int maxSubArray(int[] nums) {


        // Edge case: if the input array is empty, return 0
        if(nums.length == 0){
            return 0;
        }
        // Initialize maxSum and currentSum with the first element of the array
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // If currentSum is negative, reset it to the current element
            if(currentSum < 0){
                currentSum = nums[i];
            }else{
                // Otherwise, add the current element to currentSum
                currentSum += nums[i];
            }
            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;

    }

}
