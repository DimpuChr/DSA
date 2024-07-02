package org.dsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class EvenNumberOfDigits {

    // given array nums of integers, return how many of then contains even number of digits
    // ex: nums = [12,345,2,6,7896] , o/p = 2
    // above 12 contains 2 digits , 345 contains 3 digits and so on

    public static void main(String[] args) {

        int[] arr = {12,345,2,6,7896};

        //approach 1 : convert to string then count the digits length
        int actualCount = 0;
        int count = 0;
        for ( int num : arr){
            count = String.valueOf(num).length();
            if(count % 2 == 0){
                actualCount ++;
            }
            count = 0;
        }

        System.out.println(actualCount);

        //approach 2 : using log10
        int actualCount1 = 0;
        int count1 = 0;

        for (int num : arr){
            count1 = num == 0 ? 1 : (int) (Math.log10(num) + 1);
            if(count1 % 2 == 0){
                actualCount1++;
            }
            count1 = 0;
        }

        System.out.println(actualCount1);

        //approach 3 : count the digits
        int actualCount2 = 0;
        int count2 = 0;
        for (int num : arr){
            while (num > 0){
                count2++;
                num = num/ 10;
            }
            if(count2 % 2 == 0){
                actualCount2++;
            }
            count2 = 0;
        }
        System.out.println(actualCount2);
    }
}
