package org.dsa.search.binary;

public class MedianTwoSortedArrays {

    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    //
    //The overall run time complexity should be O(log (m+n)).
    //
    //
    //
    //Example 1:
    //
    //Input: nums1 = [1,3], nums2 = [2]
    //Output: 2.00000
    //Explanation: merged array = [1,2,3] and median is 2.
    //Example 2:
    //
    //Input: nums1 = [1,2], nums2 = [3,4]
    //Output: 2.50000
    //Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0, end = x;

        while (start <= end) {
            int partitionNums1 = (start + end) / 2;
            int partitionNums2 = (x + y + 1) / 2 - partitionNums1;

            int maxLeftNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int maxRightNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];

            int minLeftNums1 = (partitionNums1 == x) ? Integer.MAX_VALUE : nums1[partitionNums1];
            int minRightNums2 = (partitionNums2 == y) ? Integer.MAX_VALUE : nums2[partitionNums2];

            if (maxLeftNums1 <= minRightNums2 && maxRightNums2 <= minLeftNums1) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftNums1, maxRightNums2) + Math.min(minLeftNums1, minRightNums2)) / 2;
                } else {
                    return (double)Math.max(maxLeftNums1, maxRightNums2);
                }
            } else if (maxLeftNums1 > minRightNums2) {
                end = partitionNums1 - 1;
            } else {
                start = partitionNums1 + 1;
            }
        }
        return 0;
    }
}
