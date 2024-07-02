package org.dsa.search.binary;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int firstPosition = firstLast(arr,target,false);
        int lastPosition = firstLast(arr,target,true);
        System.out.println(Arrays.toString(new int[]{firstPosition,lastPosition}));


    }

    static int firstLast(int[] arr , int target, boolean last){

        int start = 0;
        int end = arr.length-1;
        int position = -1;
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
                if(last){
                    position = mid;
                    start = mid+1;
                } else{
                    position = mid;
                    end = mid-1;
                }
            }
        }
        return position;
    }
}
