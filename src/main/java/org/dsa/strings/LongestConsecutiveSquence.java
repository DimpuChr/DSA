package org.dsa.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSquence {

    //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    //
    //You must write an algorithm that runs in O(n) time.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [100,4,200,1,3,2]
    //Output: 4
    //Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));


    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int maxLength = 0;
        for (int num : nums){
            // Check if it's the start of a sequence
            if(!set.contains(num-1)){
                int currentSum = num;
                int currentLength = 1;
                // Count the length of the sequence
                while (set.contains(currentSum+1)){
                    currentSum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}
