package org.dsa.graphs.problems;

import java.util.*;

public class Wordladder {

    //optimixe solution using biderectional bfs

    public int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a Set for fast lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Initialize two sets for bidirectional BFS
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int ladderLength = 1;

        // Perform bidirectional BFS
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set to optimize
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            // Prepare the next level
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];

                    // Try all possible transformations
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[i] = c;
                        String transformed = new String(chars);

                        // If the transformed word is in the opposite set, we found a solution
                        if (endSet.contains(transformed)) {
                            return ladderLength + 1;
                        }

                        // If the transformed word is in the word list, add it to the next level
                        if (wordSet.contains(transformed)) {
                            nextSet.add(transformed);
                            wordSet.remove(transformed); // Remove to avoid revisiting
                        }
                    }

                    // Restore the original character
                    chars[i] = originalChar;
                }
            }

            // Move to the next level
            beginSet = nextSet;
            ladderLength++;
        }

        return 0; // No solution
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Add all words to a set for quick lookup

        Set<String> wordSet1 = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Initialize BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int depth = 1; // Starting depth (include beginWord)

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Check if the current word is the endWord
                if (currentWord.equals(endWord)) {
                    System.out.println(wordSet1);
                    return depth;
                }

                // Generate all possible neighbors (words differing by one letter)
                List<String> neighbors = getNeighbors(currentWord, wordSet);
                for (String neighbor : neighbors) {
                    queue.add(neighbor);
                    wordSet.remove(neighbor); // Mark as visited
                    wordSet1.add(neighbor);
                }
            }
            depth++;
        }

        return 0; // No transformation sequence found
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) {
            char originalChar = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue; // Skip the original character
                wordChars[i] = c;
                String newWord = new String(wordChars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            wordChars[i] = originalChar; // Restore original character
        }

        return neighbors;
    }

    public static void main(String[] args) {
        Wordladder solution = new Wordladder();
        // Example 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        //System.out.println(solution.ladderLengthOptimized(beginWord1, endWord1, wordList1)); // Output: 5
        System.out.println(solution.ladderLength(beginWord1, endWord1, wordList1)); // Output: 5

        // Example 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(solution.ladderLength(beginWord2, endWord2, wordList2)); // Output: 0
    }
}
