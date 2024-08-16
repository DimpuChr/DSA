package org.dsa.bit.math;

public class Pow {

    //Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
    //
    //
    //
    //Example 1:
    //
    //Input: x = 2.00000, n = 10
    //Output: 1024.00000
    public static void main(String[] args) {

        System.out.println(myPow(2.00, 10));
    }

    public static double myPow(double x, int n) {

         if(n < 0){
             n = -n;
             x = 1/x;
         }
         double pow = 1;
         while (n != 0){
             if((n &1) !=0){
                 pow = pow * x;
             }
             x = x*x;
             n >>>= 1;
         }

         return pow;

    }
}
