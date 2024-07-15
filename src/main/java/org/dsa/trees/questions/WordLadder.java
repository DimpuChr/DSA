package org.dsa.trees.questions;

import java.util.*;

public class WordLadder {

    //A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    //
    //Every adjacent pair of words differs by a single letter.
    //Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    //sk == endWord
    //Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence
    // from beginWord to endWord, or 0 if no such sequence exists.

    //Example 1:
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //Output: 5
    //Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    //Example 2:
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    //Output: 0
    //Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)){
            return 0;
        }
        if(wordList.contains(beginWord) && wordList.contains(endWord) && wordList.size()==2){
            return 0;
        }
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int length = 0;
        queue.offer(beginWord);
        while (! queue.isEmpty()){
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char c = 'a'; c <= 'z' ; c++) {
                        temp[j] = c;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord)){
                            return length+1;
                        }
                        if(wordList.contains(newWord) && !set.contains(newWord)){
                            queue.offer(newWord);
                            set.add(newWord);
                        }
                    }
                    
                }
            }
        }


        return length;


    }

    public static void main(String[] args) {

        WordLadder ladder= new WordLadder();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(list.size());
        System.out.println(ladder.ladderLength("hit","cog", list));
    }
}
