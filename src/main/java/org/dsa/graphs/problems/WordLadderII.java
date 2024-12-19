package org.dsa.graphs.problems;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }

        // Initialize sets for bidirectional BFS
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        // To track paths
        Map<String, List<String>> parentMap = new HashMap<>();
        boolean found = false;
        boolean isForward = true;

        while (!beginSet.isEmpty() && !endSet.isEmpty() && !found) {
            // Always expand the smaller set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                isForward = !isForward;
            }

            // Prepare the next level
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[i] = c;
                        String transformed = new String(chars);

                        String key = isForward ? word : transformed;
                        String value = isForward ? transformed : word;

                        if (endSet.contains(transformed)) {
                            found = true;
                            parentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                        }

                        if (wordSet.contains(transformed)) {
                            nextSet.add(transformed);
                            parentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
                        }
                    }

                    chars[i] = originalChar; // Restore original character
                }
            }

            wordSet.removeAll(nextSet);
            beginSet = nextSet;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            backtrackPaths(beginWord, endWord, parentMap, path, result);
        }

        return new ArrayList<>(new HashSet<>(result));
    }

    private void backtrackPaths(String current, String endWord, Map<String, List<String>> parentMap, List<String> path, List<List<String>> result) {
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!parentMap.containsKey(current)) return;

        for (String next : parentMap.get(current)) {
            if (path.contains(next)) continue; // Avoid cycles
            path.add(next);
            backtrackPaths(next, endWord, parentMap, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordLadderII solver = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solver.findLadders(beginWord, endWord, wordList));
    }

}
