import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2020/8/14 10:34 下午
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
