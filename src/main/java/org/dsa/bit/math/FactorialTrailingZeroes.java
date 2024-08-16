package org.dsa.bit.math;

public class FactorialTrailingZeroes {

    //Given an integer n, return the number of trailing zeroes in n!.
    //
    //Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
    //
    //
    //
    //Example 1:
    //
    //Input: n = 3
    //Output: 0
    //Explanation: 3! = 6, no trailing zero.

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
        System.out.println(0 !=0);
    }

    public static int trailingZeroes(int n) {
        if(n == 0){
            return 0;
        }
        long fact = factorial(n);
        int result = 0;
        while(true){
            long remainder = fact % 10;
            if(remainder == 0){
                result++;
            }else{
                break;
            }
            fact = fact/10;

        }
        return result;

    }
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
