package org.dsa.recursion.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePad {

    public static void main(String[] args) {
        //pad("","12");
        System.out.println(pad1("","12"));

        Map<Integer,String > map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        padNumChange("","27",map);
        System.out.println(padNumChangelist("","29",map));

    }

    static void pad(String processed , String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        int digit = unProcessed.charAt(0) - '0';
        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char ch = (char) ('a'+ i);
            pad(processed + ch, unProcessed.substring(1));
        }
    }

    static ArrayList<String> pad1(String processed , String unProcessed){
        if(unProcessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unProcessed.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char ch = (char) ('a'+ i);
            ans.addAll(pad1(processed + ch, unProcessed.substring(1)));
        }
        return ans;
    }

    // in this the 7 has 4 letters and 9 has 4 letters

    static void padNumChange(String processed , String unProcessed, Map<Integer,String> map){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        int digit = unProcessed.charAt(0) - '0';
        String s = map.get(digit);
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            padNumChange(processed + ch, unProcessed.substring(1),map);
        }
    }

    static List<String> padNumChangelist(String processed , String unProcessed, Map<Integer,String> map){
        if(unProcessed.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unProcessed.charAt(0) - '0';
        String s = map.get(digit);
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            List<String> strings = padNumChangelist(processed + ch, unProcessed.substring(1), map);
            answer.addAll(strings);
        }
        return answer;
    }
}
