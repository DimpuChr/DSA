package org.dsa.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class CountDuplicate {

    // count the duplicate elements in arrau
    // [1,2,4,5,6,6,9,10] ==> sorted array
    // need ti return the index
    //this example how we are returning array from recursion call

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,6,9,10};
        /*System.out.println(bruteForceSearch(arr,6));
        List<Integer> list = new ArrayList<>();
        System.out.println(recursion(arr,6,0,list));*/
        System.out.println(recursionWithoutPassingList(arr,6,0));

    }

    static List<Integer> bruteForceSearch(int[] arr, int target){

        List<Integer> list = new ArrayList<>();
        int start = 0;
        //int end = start+1;
        while(start <= arr.length-1){
            if(arr[start] == target){
                list.add(start);
                start++;
            }else{
                start++;
            }
        }
        return list;
    }

    static List<Integer> recursion(int[] arr, int target, int start, List<Integer> list){

        if(start > arr.length-1){
            return list;
        }
        if(arr[start] == target){
            list.add(start);
        }
        return recursion(arr,target,start+1,list);
    }

    static List<Integer> recursionWithoutPassingList(int[] arr, int target, int start){

        List<Integer> list = new ArrayList<>();

        if(start > arr.length-1){
            return list;
        }
        if(arr[start] == target){
            list.add(start);
        }
        List<Integer> recursion = recursionWithoutPassingList(arr, target, start + 1);
        if(!recursion.isEmpty()){
            list.addAll(recursion);
        }
        return list;
    }
}
