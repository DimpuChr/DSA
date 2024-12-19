package org.dsa.recursion.basic;

public class Main {

    public static void main(String[] args) {

        //printNumber(5);
        //System.out.println();
        //System.out.println(factorialNum(5));

        int  n = 7;
        int a =0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        fibonacci(a,b,n-2);

        String s = "abcd";
        
    }

    public static void printNumber(int number){
        if(number == 0){
            return ;
        }
        System.out.print(number + " ");

        printNumber(number - 1);
    }

    public static int factorialNum(int number){
        if(number == 1){
            return 1;
        }
        return number * factorialNum(number-1);
    }

    public static void fibonacci(int a , int b, int n){
        if(n == 0){
            return ;
        }
        int c = a+b;
        System.out.println(c);
        fibonacci(b,c,n-1);
    }
}
