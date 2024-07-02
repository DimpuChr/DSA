package org.dsa.recursion.easy;

public class FactorialNum {

    // Factorial of 5 means 5*4*3*2*1
    public static void main(String[] args) {
        System.out.println(factorial(5));

    }

    static int factorial(int num){
        int answer = num;
        if(num == 1){
            return 1;
        }
        return answer * factorial(num-1);
    }
}
