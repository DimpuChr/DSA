package org.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySyntax {

    public static void main(String[] args) {

        //int[] arr = new int[]{1,2,3,};

        int[] arr = {1,2,3,4};

        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(":::::::::");

        int[][] arr1 = {{1,2,3,4},{3,4,5,6},{6,8}};
        for (int[] ar : arr1){
            for (int r :ar){
                System.out.print(r + " ");
            }
            System.out.println();
        }

        List<Integer> list = new ArrayList<>();
        System.out.println();

        int[] maxArr = {13,4,23,9,11};
        int max = Integer.MIN_VALUE;

        for(int i : maxArr){
            if(i > max){
                max = i;
            }
        }

        System.out.println("max number is " + max);

        int min = Integer.MAX_VALUE;

        for(int i : maxArr){
            if(i < min){
                min = i;
            }
        }
        System.out.println("min number is " + min);

        int[] revArr = {1,3,23,9,18,7};
        System.out.println(Arrays.toString(revArr));
        int start = 0;
        int end = revArr.length-1;
        while (start< end){
            int temp = revArr[start];
            revArr[start] = revArr[end];
            revArr[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(revArr));

        int[] linear = {1,3,23,9,18,7};
        int target = 188;
        System.out.println(checkNumExistOrNot(linear,target));
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
