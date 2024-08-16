package org.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    //Given two strings s and t, determine if they are isomorphic.
    //
    //Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    //
    //All occurrences of a character must be replaced with another character while preserving the order of characters.
    // No two characters may map to the same character, but a character may map to itself.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "egg", t = "add"
    //Output: true

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic1(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char s1 = s.charAt(i);
            char s2 = t.charAt(i);

            if(maps.containsKey(s1)){
                if(maps.get(s1) != s2){
                    return false;
                }
            }else{
                maps.put(s1,s2);
            }

            if(mapt.containsKey(s2)){
                if(mapt.get(s2) != s1){
                    return false;
                }
            }else{
                mapt.put(s2,s1);
            }

        }
        return true;



    }

    public static boolean isIsomorphic1(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
