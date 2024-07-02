package org.dsa.recursion.easy;

public class SumOfDigits {

    //ex num = 1234 , op= 10 i.e 1+2+3+4

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234));

    }
    static int sumOfDigits(int num){
        if(num == 0){
            return 0;
        }
        return num%10 + sumOfDigits(num/10);
    }
}
