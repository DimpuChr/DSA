package org.dsa.search.linear;

public class FindNumInArray {

    //find the number present in an array or not
    //below is approach is linear approach
    // the input increases and exponentially time will increase linearly


    public static void main(String[] args) {

        int[] arr = {1,3,23,9,18,7};
        int target = 18;
        System.out.println(checkNumExistOrNot(arr,target));
    }

    static int checkNumExistOrNot(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
