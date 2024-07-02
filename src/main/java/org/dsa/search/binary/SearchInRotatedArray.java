package org.dsa.search.binary;
public class SearchInRotatedArray {
    // rotated array means normal array will rotate
    //ex [0,1,2,3,4,5,6,7] rotation 1 => [7,0,1,2,3,4,5,6]
    // [3,4,5,6,7,0,1,2] rotation is 5
    // if we see above example there two ascending orders
    //the approach is first need to find the pivot then will apply binary search

    public static void main(String[] args) {

        //int[] arr = {3,4,5,6,7,0,1,2};
        int[] arr = {3, 4, 4, 5, 6, 7, 7, 0, 1, 2, 2};
        System.out.println(findPivot(arr));
        int pivot = findPivot(arr);
        int target = 7;
        int answer;

        if (pivot == -1) {
            // Array is not rotated
            answer = binarySearch(arr, target, 0, arr.length - 1);
        } else {
            // If target is at the pivot
            if (arr[pivot] == target) {
                answer = pivot;
            } else if (target >= arr[0]) {
                answer = binarySearch(arr, target, 0, pivot - 1);
            } else {
                answer = binarySearch(arr, target, pivot + 1, arr.length - 1);
            }
        }

        System.out.println(answer);


    }

    static int findPivot(int[] arr){
        int start =0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            } if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // Skip duplicates
                if (start < end && arr[start] == arr[start + 1]) {
                    start++;
                } else if (end > start && arr[end] == arr[end - 1]) {
                    end--;
                } else {
                    start++;
                    end--;
                }
            } else if (arr[start] <= arr[mid]) {
                // Left part is sorted
                start = mid + 1;
            } else {
                // Right part is sorted
                end = mid - 1;
            }

        }
        return -1;
    }

    static int binarySearch(int[] arr , int target,int start, int end){


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
