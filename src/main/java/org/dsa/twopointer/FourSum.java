package org.dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    //Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    //
    //0 <= a, b, c, d < n
    //a, b, c, and d are distinct.
    //nums[a] + nums[b] + nums[c] + nums[d] == target
    //You may return the answer in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,0,-1,0,-2,2], target = 0
    //Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    //Example 2:
    //
    //Input: nums = [2,2,2,2,2], target = 8
    //Output: [[2,2,2,2]]

    public static void main(String[] args) {


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        // Fix the first number
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Fix the second number
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Two pointers for the remaining two numbers
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Move pointers
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
