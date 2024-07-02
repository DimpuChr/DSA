package org.dsa.recursion;

public class Basic {
    // print 1 to 5 number
    public static void main(String[] args) {
        printNum(5);
    }
    static void printNum(int num){
        if(num == 0){
            return;
        }
        printNum(num-1);
        System.out.println(num);
    }
}
