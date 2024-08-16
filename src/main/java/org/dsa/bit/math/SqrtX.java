package org.dsa.bit.math;

public class SqrtX {

    //Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
    //
    //You must not use any built-in exponent function or operator.
    //
    //For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
    //
    //
    //Example 1:
    //
    //Input: x = 4
    //Output: 2
    //Explanation: The square root of 4 is 2, so we return 2.

    public static void main(String[] args) {

        System.out.println(mySqrt(8));
        System.out.println(1/2);
        System.out.println(((double)1/4));

    }
    public static int mySqrt(int x) {
        if( x == 0 || x == 1){
            return x;
        }

        int start = 1;
        int end = x;
        int mid = -1;

        while (start <= end){
            mid = start + (end-start)/2;

            if((long)mid * mid > x){
                end = mid-1;
            } else if (mid * mid == x) {
                return mid;
            }else{
                start = mid+1;
            }
        }
        return Math.round(end);


    }
}
