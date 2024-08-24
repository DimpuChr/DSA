package org.dsa.strings;

import java.util.Arrays;

public class ThreeSumClosest {

    //Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    //
    //Return the sum of the three integers.
    //
    //You may assume that each input would have exactly one solution.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [-1,2,1,-4], target = 1
    //Output: 2
    //Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    //Example 2:
    //
    //Input: nums = [0,0,0], target = 1
    //Output: 0
    //Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        // Step 1: Sort the array
        Arrays.sort(nums); // nums becomes [-4, -1, 1, 2]

        // Step 2: Initialize the closest sum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2]; // closestSum = -4 + (-1) + 1 = -4

        // Step 3: Iterate over the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // left pointer starts just after i
            int right = nums.length - 1; // right pointer starts at the end of the array

            while (left < right) {
                // Calculate the current sum of the three elements
                int currentSum = nums[i] + nums[left] + nums[right];

                // If the current sum is closer to the target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move the pointers based on the comparison with the target
                if (currentSum < target) {
                    left++; // Move the left pointer to the right to increase the sum
                } else if (currentSum > target) {
                    right--; // Move the right pointer to the left to decrease the sum
                } else {
                    // If the currentSum equals the target, return it immediately as it's the closest possible
                    return currentSum;
                }
            }
        }
        return closestSum; // Return the closest sum found

    }
}
