package org.dsa;

import org.dsa.trees.questions.TreeNode;
import org.dsa.trees.questions.VerticalTraversalBT;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String s = "The Nation   Is Waiting";

        String[] ss = s.split(" ");
        System.out.println(ss[ss.length-1].length());
        StringBuilder sb = new StringBuilder();

        for (int i = ss.length-1; i >=0 ; i--) {
            String value = ss[i];
            if(!value.trim().isEmpty()){
                sb.append(value).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

        String[] arr = {"flower","flow","flight"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int answer =0;
        String input = "MCMXCIV";
        for(int i=0; i< input.length();i++){
            int current = map.get(input.charAt(i));
            if(i+1 < input.length() && current < map.get(input.charAt(i+1))){
                answer -= current;
            }else{
                answer += current;
            }
        }
        System.out.println(answer);

        String haystack = "sadbutsad";
        String needle = "sad";

        int i = haystack.indexOf(needle);


        String ransomNote = "aa";
        String magazine = "aab";

        HashMap<Character, Integer> mapp = new HashMap<>();
        for(char ch : ransomNote.toCharArray()){
            mapp.put(ch, mapp.getOrDefault(ch,0)+1);
        }

        for(int ii =0; ii< magazine.length(); ii++){
            if(mapp.get(magazine.charAt(i)) != null){
                mapp.put(magazine.charAt(i), mapp.get(magazine.charAt(i)) - 1);
                if((mapp.get(magazine.charAt(i)) == 0)){
                    mapp.remove(magazine.charAt(i));
                }
            }
        }

        System.out.println(mapp.isEmpty());


    }



}