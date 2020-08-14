import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2020/8/14 11:18 下午
 * 判断字序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence_392 {

    /**
     * 判断 s 是不是 t 的子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }

        for (char c : t.toCharArray()) {
            if (queue.size() != 0 && c == queue.peek()) {
                queue.poll();
            }
        }
        return queue.size() == 0;
    }
}
