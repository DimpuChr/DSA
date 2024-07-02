package org.dsa.recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    //in the simple Dice lets sat we have int[1,2,3,4,5,6]and how many ways we can make any target
    //lets say target is 4 possible answer are 4,31,112.............

    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceList("",4));


    }
    static void dice(String processed ,int target){
        if(target == 0){
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <=6 && i <= target ; i++) {
            dice(processed + i,target-i);
        }
    }

    static List<String> diceList(String processed , int target){
        if(target == 0){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <=6 && i <= target ; i++) {
            list.addAll(diceList(processed + i,target-i));
        }
        return list;
    }

}
