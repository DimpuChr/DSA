package org.dsa.twopointer;

import java.util.Arrays;

public class TwoSumII {

    //Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    // find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    //
    //Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    //
    //The tests are generated such that there is exactly one solution. You may not use the same element twice.
    //
    //Your solution must use only constant extra space.
    //
    //
    //
    //Example 1:
    //
    //Input: numbers = [2,7,11,15], target = 9
    //Output: [1,2]
    //Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    public static void main(String[] args) {
        int[] arr = {5,25,75};
        System.out.println(Arrays.toString(twoSum(arr,100)));

    }
    public static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = 1;
        while( start < numbers.length-1 && end < numbers.length){
            if(numbers[start] + numbers[end] == target){
                return new int[] {start+1, end+1};
            }
            if(end == numbers.length-1) {
                start++;
                end = start +1;
            }else{
                end++;
            }

        }
        return new int[]{};

    }
}
