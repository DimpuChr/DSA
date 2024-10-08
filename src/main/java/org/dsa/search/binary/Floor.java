package org.dsa.search.binary;

public class Floor {

    // Floor of a number in array means return the biggest smallest or equal number target
    //the floor is the greatest element smaller than or equal to x
    public static void main(String[] args) {

        int[] arr = {2,3,5,9,14,16,18};
        int target = 15;
        System.out.println(floor(arr,target));
    }

    static int floor(int[] arr , int target){
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
        return end;
    }
}
