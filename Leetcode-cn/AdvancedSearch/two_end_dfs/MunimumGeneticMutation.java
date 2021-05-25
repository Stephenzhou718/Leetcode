package AdvancedSearch.two_end_dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhouhanming
 * @Date:2021/5/22 10:39 下午
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 *
 * 思路：
 * 1. 双端 BFS
 *
 * 五毒神掌：
 * 第二遍，2021/5/22
 * 第三遍，2021/5/25
 */
public class MunimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }

        // 1. 初始化 visited, startSet, endSet
        Set<String> visited = new HashSet<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (bankSet.contains(end)) return -1;

        startSet.add(start);
        endSet.add(end);

        int count = 0;
        char[] mode = new char[]{'A', 'G', 'C', 'T'};
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            // 2. 从小端开始
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }

            // ⒊ 开始 BFS
            Set<String> tmpSet = new HashSet<>();
            for (String word : startSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] charArr = word.toCharArray();
                    char originChar = charArr[i];
                    for (char ch : mode) {
                        if (originChar == ch) {
                            continue;
                        }

                        charArr[i] = ch;
                        String newStr = new String(charArr);
                        if (bankSet.contains(newStr)) {
                            // 4. startSet 与 endSet 有交集，finded！
                            if (endSet.contains(newStr)) {
                                return count+1;
                            }
                            if (!visited.contains(newStr)) {
                                tmpSet.add(newStr);
                                visited.add(newStr);
                            }
                        }
                    }
                    charArr[i] = originChar;
                }
            }
            count++;
            startSet = tmpSet;
        }
        return -1;
    }
}
