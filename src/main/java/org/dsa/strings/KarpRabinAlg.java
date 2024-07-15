package org.dsa.strings;

public class KarpRabinAlg {

    //The Karp-Rabin algorithm is a string searching algorithm that uses hashing to find one or more occurrences of a pattern (substring) in a text (main string).
    // It is particularly efficient in average-case scenarios and works by comparing hash values rather than direct character comparisons for potential matches.
    // Here's an explanation of how the Karp-Rabin algorithm works in Java:
    //steps of the Karp-Rabin Algorithm:
    //Hash Function Selection:
    //Choose a hash function that efficiently computes hash values for substrings. A common choice is polynomial rolling hash.
    //Compute Hash Values:
    //Compute the hash value of the pattern (substring) and of each window of the text (main string) with the same length as the pattern.
    //Comparison of Hash Values:
    //
    //Compare the hash values of the pattern and each window of the text. If the hash values match, perform a character-by-character comparison to confirm the match.
    //Collision Handling (Optional):
    //If hash values match but characters don't, handle collisions by checking the actual substring against the pattern.

    // Prime number used in the hash function for better distribution
    final int PRIME_NUM = 101;

    // Calculate hash value using a polynomial rolling hash function
    public double calculateHash(String text){
        double hash = 0;
        for (int i = 0; i < text.length(); i++) {
            hash = (hash + text.charAt(i) * Math.pow(PRIME_NUM , i));
        }
        return hash;
    }

    public double updateHash(double prevHash , char oldChar , char newChar, int patternLength){
        double newHash = prevHash - oldChar ;
        newHash = newHash / PRIME_NUM;
        newHash = newHash + newChar * Math.pow(PRIME_NUM, patternLength -1);
        return newHash;
    }

    public void findSubstring(String text , String pattern){
        int patternLength = pattern.length();
        int textLength = text.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0,patternLength));

        for (int i = 0; i < (textLength-patternLength); i++) {
            if(textHash == patternHash){
                if(text.substring(i, i+ patternLength).equals(pattern)){
                    System.out.println("substring found at index "+ i);
                }
            }
            if(i < (textLength-patternLength)){
                textHash = (int) updateHash(textHash,text.charAt(i), text.charAt(i + patternLength),patternLength);
            }
        }
    }

    public static void main(String[] args) {

        String s = "tdarshan";
        String substring = "darshan";

        KarpRabinAlg alg = new KarpRabinAlg();

        // Call custom method to check if substring exists
        alg.findSubstring(s,substring);

        System.out.println(alg.calculateHash(substring));
        System.out.println(alg.calculateHash(s.substring(1,8)));
        System.out.println(alg.updateHash(117797638253837L,'t','n',substring.length()));
    }
}
