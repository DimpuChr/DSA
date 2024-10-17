package org.dsa.strings;

public class MergeAlt {

    public static void main(String[] args) {

        System.out.println(mergeAlternately("abcd","pq"));


    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int count =  0;
        for(int i =0; i < word1.length() && i< word2.length(); i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            count ++;
        }
        if(count < word1.length()){
            sb.append(word1.substring(count,word1.length()));
        }
        if(count < word2.length()){
            sb.append(word2.substring(count,word2.length()));
        }
        return sb.toString();

    }
}
