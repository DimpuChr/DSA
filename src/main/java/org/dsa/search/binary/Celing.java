package org.dsa.search.binary;

public class Celing {

    // Find the number greater than or equal to target
    //[2,3,5,9,14,16,18] target is 15 . 15 is not found in the array so the smallest greater number is 16
    //the ceiling of x is the smallest element in an array greater than or equal to x

    public static void main(String[] args) {

        int[] arr = {2,3,5,9,14,16,18};
        int target = 15;
        System.out.println(ceiling(arr,target));
    }

    static int ceiling(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        if(target > arr[end]){
            return -1;
        }
        while (start <= end){
            int mid = start + (end-start)/2;
            if(target > arr[mid]){
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid-1;
            }else{
                return mid;
            }
        }
        return start;
    }
}
