package org.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesfromSortedArrayII {
    //Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
    // The relative order of the elements should be kept the same.
    //
    //Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
    // More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
    // It does not matter what you leave beyond the first k elements.
    //
    //Return k after placing the final result in the first k slots of nums.
    //
    //Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
    //Input: nums = [1,1,1,2,2,3]
    //Output: 5, nums = [1,1,2,2,3,_]
    //Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).

    public static void main(String[] args) {
        int[] nums= {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        int[] nums1= {1,1,1,2,2,3};
        System.out.println(remove(nums1));
    }

    public static int removeDuplicates(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]) || map.get(nums[i]) < 2){
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                nums[left++] = nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;

    }

    public static int remove(int[] nums){
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
