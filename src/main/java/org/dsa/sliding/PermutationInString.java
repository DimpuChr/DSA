package org.dsa.sliding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    //Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    //
    //In other words, return true if one of s1's permutations is the substring of s2.
    //Example 1:
    //
    //Input: s1 = "ab", s2 = "eidbaooo"
    //Output: true
    //Explanation: s2 contains one permutation of s1 ("ba").

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
        System.out.println('d' - 'a');
    }
    public static boolean checkInclusion(String s1, String s2) {
        boolean answer = false;
        if(s1.length() > s2.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i =0 ; i< s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(arr1,arr2)) return true;
        int left = 0;
        int right = s1.length();
        while (right < s2.length()){
            arr2[s2.charAt(right - s1.length()) -'a']--;
            arr2[s2.charAt(right) - 'a']++;
            if(Arrays.equals(arr1,arr2)) return true;
            right++;
            left++;
        }

        return answer;
    }
}
