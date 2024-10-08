package org.dsa.arrays;

public class TrappingRainWater {

    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    //Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    //Example 2:
    //
    //Input: height = [4,2,0,3,2,5]
    //Output: 9

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    totalWater += maxLeft - height[left];
                }
                left++;
            }else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}
