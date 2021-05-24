package AdvancedSearch.two_end_dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhouhanming
 * @Date:2021/5/22 10:39 下午
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * 思路：
 * 1. BFS
 * 2. 双向 BFS
 *
 * 五毒神掌：
 * 第二遍，2021/5/22
 * 第三遍，2021/5/24
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 1. 初始化 beginSet, endSet, visited
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        // 2. 添加 beginWord, endWord
        beginSet.add(beginWord);
        endSet.add(endWord);

        int count = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 3. 从BFS 扩散少的一边开始扩散
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            // 4. BFS
            Set<String> tempSet = new HashSet<>();
            for (String word : beginSet) {
                char[] charArr = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char originChar = charArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == charArr[i]) {
                            continue;
                        }

                        charArr[i] = ch;
                        String newStr = new String(charArr);
                        if (wordSet.contains(newStr)) {
                            // 5. beginSet 与 endSet 有交集, 找到结果
                            if (endSet.contains(newStr)) {
                                return count + 1;
                            }

                            if (!visited.contains(newStr)){
                                visited.add(newStr);
                                tempSet.add(newStr);
                            }
                        }
                    }
                    charArr[i] = originChar;
                }
            }
            beginSet = tempSet;
            count++;
        }
        return 0;
    }
}
