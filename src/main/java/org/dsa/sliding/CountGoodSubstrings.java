package org.dsa.sliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountGoodSubstrings {

    //https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
    //A string is good if there are no repeated characters.
    //
    //Given a string s, return the number of good substrings of length three in s.
    //
    //Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
    //
    //A substring is a contiguous sequence of characters in a string.
    //Example 1:
    //
    //Input: s = "xyzzaz"
    //Output: 1
    //Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
    //The only good substring of length 3 is "xyz".

    public static void main(String[] args) {
        String s= "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }

    public static int countGoodSubstrings(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() ==0){
            return answer;
        }
        int left =0;
        int right = 0;
        while(right < s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(right - left +1 == 3){
                if(checkDuplicate(map)){
                    answer++;
                }
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        return answer;
    }

    private static boolean checkDuplicate(Map<Character, Integer> map){
        for (char ch : map.keySet()){
            if(map.get(ch) > 1){
                return false;
            }
        }
        return true;
    }
}
