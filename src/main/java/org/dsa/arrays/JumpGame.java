package org.dsa.arrays;

public class JumpGame {

    //You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    //
    //Return true if you can reach the last index, or false otherwise.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [2,3,1,1,4]
    //Output: true
    //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));
        int[] arr1 = {1,2,1,1,1};
        System.out.println(canJumpII(arr1));

    }
    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static int canJumpII(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The end of the range that can be reached with the current number of jumps
        int farthest = 0; // The farthest index that can be reached from the current position

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current range, we must jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the current end reaches or exceeds the last index, we can stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
