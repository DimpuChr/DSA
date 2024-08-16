package org.dsa.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    //Given a pattern and a string s, find if s follows the same pattern.
    //
    //Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
    //
    //
    //
    //Example 1:
    //
    //Input: pattern = "abba", s = "dog cat cat dog"
    //Output: true

    public static void main(String[] args) {

        String patter = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(patter,s));


    }

    public static boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (wordToChar.containsKey(word)) {
                    return false;
                }
                charToWord.put(c, word);
                wordToChar.put(word, c);
            }
        }

        return true;

    }
}
