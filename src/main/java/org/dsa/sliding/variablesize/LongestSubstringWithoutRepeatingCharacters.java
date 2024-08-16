package org.dsa.sliding.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest
    //substring
    // without repeating characters.
    //Example 1:
    //
    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    //Example 2:
    //
    //Input: s = "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.

    public static void main(String[] args) {
        String s = "abcaacbd";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left =0;
        Map<Character,Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if(!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < left){
                answer = Math.max(answer,right-left+1);
                map.put(s.charAt(right),right);
            }else {
                left = map.get(s.charAt(right))+1;
                map.put(s.charAt(right),right);
            }
        }
        return answer;

    }
}
