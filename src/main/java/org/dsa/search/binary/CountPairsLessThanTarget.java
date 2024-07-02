package org.dsa.search.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class CountPairsLessThanTarget {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(-6);
        list.add(2);
        list.add(5);
        list.add(-2);
        list.add(-7);
        list.add(-1);
        list.add(3);
        Arrays.toString(list.toArray());
        int target1 = -2;
        int clt = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i) +list.get(j) < target1){
                    clt++;
                }
            }

        }


        System.out.println(clt);

        int[] arr = {-6,2,5,-2,-7,-1,3};
        int target = -2;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+ arr[j] < target){
                    count++;
                }
            }

        }

        System.out.println(count);

        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(1);

        Arrays.sort(list1.toArray());
        Collections.sort(list1);
        System.out.println(list1);

        int start = 0;
        int end = 1;
        int length = list1.size();
        int target11 = 2;
        int count11 = 0;
        while(start < length-1){
            if(list1.get(start) + list1.get(end) < target11){
                count11++;
                if(end < list1.size()) {
                    end++;
                }
            } else if(end < list1.size()) {
                end++;
            }
            if(end == list1.size()){
                start ++;
                end = start +1;
            }
        }

        System.out.println(count11);

    }
}
