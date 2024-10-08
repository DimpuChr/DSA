package org.dsa.bit.math.bit;

public class NumberofOneBits {

    //Write a function that takes the binary representation of a positive integer and returns the number of
    //set bits
    // it has (also known as the Hamming weight).
    //
    //
    //
    //Example 1:
    //
    //Input: n = 11
    //
    //Output: 3
    //
    //Explanation:
    //
    //The input binary string 1011 has a total of three set bits.

    public static void main(String[] args) {
        System.out.println(hammingWeight(29));

    }

    public static int hammingWeight(int n) {
        int count =0;
        while (n !=0){
            count += n&1;
            n>>=1;
        }
        return count;

    }
}
