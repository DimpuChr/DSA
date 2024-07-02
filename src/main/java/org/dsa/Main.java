package org.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s= "Darshabn";
        System.out.println(s.length());
        System.out.println("Hello world!");

        List<Integer> list = new ArrayList<>();
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);

        System.out.println(list);

        int[] arr = new int[3];
        arr[0] = 2;
        arr[0] = 3;
        arr[0] = 4;
        System.out.println(Arrays.toString(arr));

    }
}