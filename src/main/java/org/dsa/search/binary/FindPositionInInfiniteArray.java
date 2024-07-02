package org.dsa.search.binary;

public class FindPositionInInfiniteArray {

    //given infinite array need to find the position of target value
    // the approach we are following is binary search but we dont know the size of array
    // we need to check chunk/part by part weather the target lis in that or not by doubling the window size

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,11,14,15,17,18,19,32,34,34,45,46};
        int target = 15;
        System.out.println(findAnswer(arr,target));

    }

    static int findAnswer(int[] arr , int target){

        int start = 0;
        int end = 1;
        while (target > arr[end]){
            int temp = end+1;
            end = end + (end - start + 1) *2;
            start = temp;
        }
        return binarySearch(arr,target,start,end);


    }

    static int binarySearch(int[] arr , int target, int start , int end){

        //int start = 0;
        //int end = arr.length-1;
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
