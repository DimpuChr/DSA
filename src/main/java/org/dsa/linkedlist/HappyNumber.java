package org.dsa.linkedlist;

public class HappyNumber {

    //write a algorithm to determine n is happy
    //A happy number is a number defined by the following process
    //starting with any positive integer, replace the number by the sum of the square of its digits
    //Repeate the process untill the number equals to 1 (where it will stay) or it loops endlessly in a cycle which doesnot include 1
    //those numbers for which this process ends in 1 are happy

    public static void main(String[] args) {

        int number = 12;
        //int number = 19;
        System.out.println(isHappy(number));
    }

    static boolean isHappy(int number){
        int slow = number;
        int fast = number;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while (slow != fast);

        if(slow == 1){
            return true;
        }
        return false;
    }

    static int findSquare(int number){

        int answer = 0;
        while (number > 0){
            int remainder = number % 10 ;
            answer += remainder *remainder;
            number /= 10;
        }
        return answer;

    }

}
