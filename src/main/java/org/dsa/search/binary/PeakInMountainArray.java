package org.dsa.search.binary;

public class PeakInMountainArray {

    //Peak in mountain array means one asending order and next art of array in desending order
    //ex : [1,2,4,5,4,3,2,1] => in this [1,2,4,5] is ascending part of array and [4,3,2,1] is descending part of array
    // peak in above is 5
    public static void main(String[] args) {

        int[] arr = {1,2,4,5,4,3,2,1};
        System.out.println(binarySearch(arr));

    }
    static int binarySearch(int[] arr ){

        int start = 0;
        int end = arr.length-1;
        //we are loop voilation is start < end because if start and end equals we will found the peak
        while (start < end){
            //below might exceed the int range
            //int mid = (start + end) /2 ;
            //better approach is like below
            int mid = start + (end - start )/2 ;
            // in this we know it is in desending part of array , it might be the possible answer so we are moving end till mid only
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            // in this we know mid is in asending order and we are searching for highest number that is peak , so better to move start to mid+1 because we know mid is smaller than mid +1
            else if (arr[mid] < arr[mid+1]) {
                start = mid+1;
            }
        }
        return arr[start];
    }
}
