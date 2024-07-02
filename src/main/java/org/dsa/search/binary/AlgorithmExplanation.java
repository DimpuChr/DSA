package org.dsa.search.binary;

public class AlgorithmExplanation {

    // is a search algorithm used to find the position of a target value within a sorted array.
    // It works by repeatedly dividing the search interval in half until the target value is found or the interval is empty.
    // The search interval is halved by comparing the target element with the middle value of the search space.
    // time complexity calculation , n/2 ,n/4 / n/8 ..........n/k = n/2^K -->  logn

    public static void main(String[] args) {

        int[] arr = {2,4,7,8,23,32,54,76};
        int target = 23;
        System.out.println(binarySearch(arr, target));

    }

    static int binarySearch(int[] arr , int target){

        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            //below might exceed the int range
            //int mid = (start + end) /2 ;
            //better approach is like below
            int mid = start + (end - start )/2 ;
            if(target > arr[mid]){
                start = mid+1;
            } else if (target < arr[mid]) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
