package org.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "anagram", t = "nagaram"
    //Output: true

    public static void main(String[] args) {

        String s ="rat";
        String s1= "car";
        System.out.println(isAnagram1(s,s1));


    }
    public static boolean isAnagram(String s, String t) {

        if(s.length() > t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i)) ==0){
                    map.remove(t.charAt(i));
                }
            }
        }
        return map.isEmpty();

    }
    public static boolean isAnagram1(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) -'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) -'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }

        }

        return true;

    }


}
