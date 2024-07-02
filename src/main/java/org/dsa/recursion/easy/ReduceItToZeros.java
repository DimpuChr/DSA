package org.dsa.recursion.easy;

public class ReduceItToZeros {

    // Given an integer num , return the number of steps to reduce it to zeros
    // In one step if the current number is even you have to divided by 2 , otherwise ypu have to substract 1 from it
    //num = 14 , o/p = 6
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    static int numberOfSteps(int num ){
        int steps = 0;
        if(num == 0){
            return 0;
        }
        if(num % 2 == 0){
            return (steps + 1) + numberOfSteps(num/2);
        }
        return (steps+1) + numberOfSteps(num-1);
    }
}
