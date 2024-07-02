package org.dsa.recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subseq {

    //abc
    // [a],[b],[c],[a,b,c],[a,c],[b,c],[ab]
    public static void main(String[] args) {

        subseq("" , "abc");
        System.out.println(subseqWithArray("","abc"));

        //iteration way

        int[] arr = {1,2,3};
        System.out.println(subsetIteration(arr));
    }

    static  void subseq(String processed , String unprocessed){

        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subseq(processed + ch , unprocessed.substring(1));
        subseq(processed  , unprocessed.substring(1));
    }

    static ArrayList<String> subseqWithArray(String processed ,String unprocessed){

        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subseqWithArray(processed + ch , unprocessed.substring(1));
        ArrayList<String> right = subseqWithArray(processed  , unprocessed.substring(1));
        left.addAll(right);
        return left;
    }

    static List<List<Integer>> subsetIteration(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
