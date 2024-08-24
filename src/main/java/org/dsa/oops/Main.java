package org.dsa.oops;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       List<String> list = null;
       System.out.println(list);
        list =get(Arrays.asList("Darshan"));
        System.out.println(list);
        list = get(Arrays.asList("Dimpu"));

        System.out.println(list);


        String s= " ";

        if(!s.isBlank()){
            System.out.println("KKKKKKKKKK");

        }
        List<String> listt = new ArrayList<>(Arrays.asList("suma"));
        listt.add("demon");

        List<String> collect = listt.stream().distinct().collect(Collectors.toList());

        System.out.println(collect);

        int[] arr = {1,2,3};
        System.out.println(arr.length);

        int closSum = 4;
        int currentSum = 3;

        System.out.println("::::::::");
        System.out.println(Math.abs(closSum-1));
        System.out.println(Math.abs(currentSum-1));
    }

    static List<String> get(List<String> list){
        List<String> ll = new ArrayList<>();
        ll = list;
        return ll;
    }


}
