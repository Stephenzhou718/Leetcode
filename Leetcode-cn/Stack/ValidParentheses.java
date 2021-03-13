package Stack;

import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/7 8:36 下午
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 思路：
 * 1. 栈: 时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍, 2021/3/7
 * 第三遍, 2021/3/13
 * 第四遍，2021/3/20
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
