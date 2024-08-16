package org.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    //Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,2,3,1], k = 3
    //Output: true
    //Input: nums = [1,2,3,1,2,3], k = 2
    //Output: false

    public static void main(String[] args) {

        int[] arr = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(arr,k));


    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer , Integer> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    result = true;
                }else{
                    result = false;
                }
            }
            map.put(nums[i],i);
        }
        return result;

    }
}
