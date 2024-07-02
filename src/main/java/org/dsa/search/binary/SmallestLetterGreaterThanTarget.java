package org.dsa.search.binary;

public class SmallestLetterGreaterThanTarget {

    //find the smallest letter greater than target
    //letter may wrap around
    //for example , if target == 'z' and letters == ['a','b'] , the answer is 'a'

    public static void main(String[] args) {

        char[] arr = {'a','b','c','f'};
        char target = 'd';
        System.out.println(smallestLetter(arr,target));

    }

    static char smallestLetter(char[] arr , char target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(target > arr[mid]){
                start = mid+1;
            } else if (target < arr[mid]) {
                end = mid-1;
            }

        }
        return arr[start% arr.length];
    }
}
