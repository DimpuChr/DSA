package org.dsa.search.binary;

public class SplitArrayLargestSum {

    //Hard
    //Given an array nums which consists of non-negative and an integer m ,you can split the array into m non-empty continuous subarrays
    //write an algorithm to minimize the largest sum among these subarrays
    //ex : [7,2,5,10,8] m= 2  o/p 18
    // in an array the minimum parition we can made is 1 and maximum partion made is arrays length
    // so we got the start and end  we can apply binary search
    //next take the mid and check how many partions can make
    // If partions greater than given num then increase the start
    // If partions less than or equal to num then reduce the mid and check for other possible answers


    public static void main(String[] args) {

        int[] arr = {7,2,5,10,8};
        int nums = 2;
        System.out.println(splitArraySum(arr,nums));
        
    }

    static int splitArraySum(int[] arr, int nums){
        int start = 0;
        int end = 0;
        for (int i =0 ; i<= arr.length-1 ; i++){
            start = Math.max(start , arr[i]);
            end += arr[i];
        }
        while (start < end){

            int mid = start + (end - start)/2;
            int partions = 1;
            int sum = 0;
            for (int num : arr){
                if(sum + num > mid){
                   sum = num;
                   partions++;
                }else{
                    sum += num;
                }
            }
            if(partions > nums){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
