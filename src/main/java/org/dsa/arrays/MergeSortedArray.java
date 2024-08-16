package org.dsa.arrays;

import java.util.Arrays;

public interface MergeSortedArray {

    //You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    // representing the number of elements in nums1 and nums2 respectively.
    //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    //
    //The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    // To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    // and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
    //Example 1:
    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
    //Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    //The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    public static void main(String[] args) {
        int[] nums = {1,2,3,0,0,0};
        int[] nums1 = {2,5,6};
        merge(nums,3,nums1,3);
        System.out.println(Arrays.toString(nums));

    }
    public static void merge(int[] arr, int m, int[] arr1, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j>=0){
            if(i>=0 && arr[i] > arr1[j]){
                arr[k--] = arr[i--];
            }else{
                arr[k--] = arr1[j--];
            }
        }
    }
}
