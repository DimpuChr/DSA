package org.dsa.recursion.subsets;

import java.util.ArrayList;

public class Permutation {

    //Permutations of "abc" is like abc,bca,aca,................
    //the idea is here we are not ignoring anything
    //take processed and unprocessed
    //base condition is un processed till end
    // now the condition is like suppose if take first a then remaing bc
    // now possible way to add b for a is either ab or ba
    // so the recursion call is not constatnt it based on the size of the character present

    public static void main(String[] args) {

        permutationWithPrint("","abc");
        System.out.println(permutationWithReturn("","abc"));
        System.out.println(permutationWithReturnCount("","abc"));
    }

    static void permutationWithPrint(String processed , String unprocseed){

        if(unprocseed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocseed.charAt(0);
        for (int i = 0; i <= processed.length() ; i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            permutationWithPrint(first + ch + second , unprocseed.substring(1));
        }

    }

    static ArrayList<String> permutationWithReturn(String processed , String unprocseed){

        if(unprocseed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch = unprocseed.charAt(0);
        for (int i = 0; i <= processed.length() ; i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            ans.addAll(permutationWithReturn(first + ch + second , unprocseed.substring(1)));
        }
        return ans;
    }

    static int permutationWithReturnCount(String processed , String unprocseed){

        if(unprocseed.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = unprocseed.charAt(0);
        for (int i = 0; i <= processed.length() ; i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            count = count + permutationWithReturnCount(first + ch + second , unprocseed.substring(1));
        }
        return count;
    }
}
