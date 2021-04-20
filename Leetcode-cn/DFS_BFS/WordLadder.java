package DFS_BFS;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/4/18 9:35 下午
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * 思路：
 * 1. BFS
 * 2. 双向 BFS
 *
 * 五毒神掌：
 * 第二遍：2021/4/19
 * 第三遍：2021/4/20
 */
public class WordLadder {

    // 单向 BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        HashSet<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList();
        deque.addLast(beginWord);
        visited.add(beginWord);

        int setp = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String currentWord = deque.pollFirst();
                if (changeWordEveryOneLetter(currentWord, endWord, deque, visited, wordSet)) {
                    return setp + 1;
                }
            }
            setp++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter(String currentWord, String endWord, Deque<String> deque, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < currentWord.length(); i++) {
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (originChar == k) {
                    continue;
                }

                charArray[i] = k;
                String nextWord = new String(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        deque.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }


    // 双向 BFS
    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;
        while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }

                charArray[i] = c;
                String nextWord = new String(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
                charArray[i] = originChar;
            }
        }
        return false;
    }
}
