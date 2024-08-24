package org.dsa.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {

    //Given a string s, return the longest
    //palindromic
    //
    //substring
    // in s.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "babad"
    //Output: "bab"
    //Explanation: "aba" is also a valid answer.
    //Example 2:
    //
    //Input: s = "cbbd"
    //Output: "bb"

    int startIndex;
    int totalLength;
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));

        LongestPalindromicSubstring ll = new LongestPalindromicSubstring();
        System.out.println(ll.longestSubstring1("babad"));
    }

    public static  String longestPalindrome(String s) {

        if(s== null || s.length() <1) return  "";
        int maxlength = 0;
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i,j+1);
                if(checkPalindrone(sub) && sub.length() > maxlength){
                    maxlength = sub.length();
                    longestSubstring = sub;
                }

            }
        }
        return longestSubstring;
    }

    public static boolean checkPalindrone(String s){
        int start = 0;
        int end = s.length()-1;
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Expand Around Center:
    //
    //For each character in the string, treat it as the center of a potential palindrome.
    //There are two cases to consider:
    //The palindrome has an odd length (center is a single character).
    //The palindrome has an even length (center is between two characters).
    //For each center, expand outwards while the characters on both sides are equal.
    //Tracking the Longest Palindrome:
    //
    //Keep track of the start and end indices of the longest palindromic substring found.
    //Update the start and end indices whenever a longer palindrome is found.
    //Time Complexity:
    //
    //The algorithm expands around each character or pair of characters (for odd and even length palindromes), making the time complexity
    //𝑂
    //(
    //𝑛
    //2
    //)
    //O(n
    //2
    // ), where
    //𝑛
    //n is the length of the string.

    public String longestSubstring1(String s){

        for (int i = 0; i < s.length(); i++) {
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(startIndex, startIndex+totalLength);
    }

    public void expand(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(totalLength < end-start-1){
            startIndex = start +1;
            totalLength = end-start-1;
        }
    }


}
