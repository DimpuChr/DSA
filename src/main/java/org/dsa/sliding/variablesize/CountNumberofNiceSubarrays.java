package org.dsa.sliding.variablesize;

public class CountNumberofNiceSubarrays {

    //Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
    //
    //Return the number of nice sub-arrays.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,1,2,1,1], k = 3
    //Output: 2
    //Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums,3));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int length = nums.length;
        int left = 0;
        int count = 0;
        for (int right = 0; right < length; right++) {
            if(nums[right] % 2 == 1){
                k--;
                count =0;
            }
            while (k ==0){
                k += nums[left++] &1;
                count++;
            }
            answer += count;

        }

        return answer;

    }
}
