package org.dsa.twopointer;

public class IsSubsequence {


    //Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //
    //A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    // of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
    //Example 1:
    //
    //Input: s = "abc", t = "ahbgdc"
    //Output: true

    public static void main(String[] args) {
        String s = "axc";
        String s2 = "ahbgdc";
        System.out.println(isSubsequence(s,s2));

    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length()> t.length()){
            return false;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        while(start < s.length() && end < t.length()){
            if(s.charAt(start) == t.charAt(end)){
                count++;
                start++;
            }
            end++;
        }
        if(count == s.length()){
            return true;
        }
        return false;

    }
}
