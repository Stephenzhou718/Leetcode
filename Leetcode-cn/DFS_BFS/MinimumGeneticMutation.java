package DFS_BFS;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: zhouhanming
 * @Date:2021/3/18 9:20 下午
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 *
 * 思路：
 * 1.
 *
 * 五毒神掌：
 * 第二遍，2021/3/18
 */
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }

        char[] four = {'A', 'G', 'C', 'T'};
        Deque<String> deque = new LinkedList<>();
        int step = 0;
        deque.addLast(start);
        set.remove(start);
        while (deque.size() > 0) {
            step++;
            int size = deque.size();
            for (int count =  0; count < size; count++) {
                char[] chars = deque.pollFirst().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char c : four) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (newStr.equals(end)) {
                            return step;
                        } else if (set.contains(newStr)) {
                            set.remove(newStr);
                            deque.addLast(newStr);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
        }
        return -1;
    }
}
