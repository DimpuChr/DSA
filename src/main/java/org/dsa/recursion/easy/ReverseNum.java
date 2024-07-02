package org.dsa.recursion.easy;

public class ReverseNum {
    static int sum = 0;

    public static void main(String[] args) {

        int num = 1234;
        reverseNumStr(num);
        System.out.println(sum);
        System.out.println(helperToCalculate(num));

    }

    static void reverseNumStr(int num){
        if(num == 0){
            return;
        }
        int remainder = num%10;
        sum = sum*10 + remainder;
        reverseNumStr(num/10);
    }

    //another way

    static int helperToCalculate(int num){
        int numDigits = (int)Math.log10(num) +1 ;
        return calculate(num,numDigits);
    }

    static int calculate(int num , int digits){
        if(num == 0){
            return 0;
        }
        return num%10 * (int)Math.pow(10,digits-1) + calculate(num/10 , digits-1);
    }
}
