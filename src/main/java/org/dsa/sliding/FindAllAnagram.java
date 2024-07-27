package org.dsa.sliding;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {

    //Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "cbaebabacd", p = "abc"
    //Output: [0,6]
    //Explanation:
    //The substring with start index = 0 is "cba", which is an anagram of "abc".
    //The substring with start index = 6 is "bac", which is an anagram of "abc".

    public static void main(String[] args) {
        String s = "af";
        String p ="be";
        System.out.println(findAnagrams(s,p));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()){
            sCount[s.charAt(right) - 'a']++;
            if(right - left +1 == p.length()){
                if(checkAnagram(sCount,pCount)){
                    list.add(left);
                }
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return list;

    }

    private static boolean checkAnagram(int[] first , int[] second){
        for (int i = 0; i < 26; i++) {
            if(first[i] != second[i]){
                return false;
            }
        }
        return true;
    }
}
