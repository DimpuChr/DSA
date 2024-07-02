package org.dsa.recursion.easy;

public class FibonacciSeries {

    //very inefficent
    //linear recursion
    //2^n

    public static void main(String[] args) {

        System.out.println(fibo(50));
    }

    static int fibo(int n){
        if(n < 2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
