package org.dsa.strings;

import java.util.*;

public class GroupAnagrams {

    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    //
    //
    //
    //Example 1:
    //
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String , List<String>> map = new HashMap<>();

        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());

    }
}
