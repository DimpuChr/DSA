package org.dsa.oops;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] nums = {20,100,10,12,5,13};
        System.out.println(check(nums));

    }
    public static boolean check(int[] nums){
        int count =0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                count++;
                if(count== 2){
                    return  true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }





}
