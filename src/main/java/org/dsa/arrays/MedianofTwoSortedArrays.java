package org.dsa.arrays;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    //The overall run time complexity should be O(log (m+n)).
    //Example 1:
    //Input: nums1 = [1,3], nums2 = [2]
    //Output: 2.00000
    //Explanation: merged array = [1,2,3] and median is 2.
    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr1 = {3,4};
        System.out.println(findMedianSortedArrays(arr,arr1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] dummy = new int[nums1.length + nums2.length];
        int k =0;
        for (int i = 0; i < nums1.length; i++) {
            dummy[k++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            dummy[k++] = nums2[i];
        }
        Arrays.sort(dummy);
        int total = dummy.length;

        if(total % 2 == 1){
            return (double) dummy[total /2];

        }else{
            int mid1 = dummy[total /2 -1];
            int mid2 = dummy[total /2];
            return (double) (mid1+mid2)/2.0;
        }
    }

    //using Binary Search Approach
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double)Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0;

    }
}
