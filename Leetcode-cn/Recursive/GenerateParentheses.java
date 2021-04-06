package Recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 2:57 下午
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 思路：
 *
 * 五毒神掌：
 * 第二遍：2021/3/14
 * 第三遍: 2021/4/6
 * 第四遍：
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrace(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrace(List<String> res, StringBuilder sb, int left, int right, int n) {
        // 终止条件
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            // process
            sb.append('(');

            // drill down
            backtrace(res, sb, left + 1, right, n);

            // restore
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            backtrace(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
