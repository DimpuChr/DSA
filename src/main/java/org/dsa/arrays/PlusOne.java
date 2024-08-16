package org.dsa.arrays;

import java.util.Arrays;

public class PlusOne {

    //You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    // The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    //
    //Increment the large integer by one and return the resulting array of digits.
    //
    //
    //
    //Example 1:
    //
    //Input: digits = [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //Incrementing by one gives 123 + 1 = 124.
    //Thus, the result should be [1,2,4].
    //[ 5,9 ]-->[ 5,0 ]-loop->[ 6,0 ] or
    //	//      [ 1,9,9 ]-->[ 1,9,0 ]-loop->[ 1,0,0 ]-loop->[ 2,0,0 ]

    public static void main(String[] args) {

        int[] arr = {1,2,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    public static int[] plusOne(int[] digits) {

        for(int i = digits.length-1; i>=0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] =0;
        }

        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }

}
