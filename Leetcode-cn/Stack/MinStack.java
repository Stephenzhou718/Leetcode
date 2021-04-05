package Stack;

import java.util.Stack;

/**
 * @Author: zhouhanming
 * @Date:2021/3/7 8:36 下午
 * https://leetcode-cn.com/problems/min-stack/
 * 思路：
 * 1. 辅助栈
 *
 * 五毒神掌：
 * 第二遍, 2021/3/7
 * 第三遍, 2021/3/13
 * 第四遍, 2021/4/5
 *
 * 两个栈 / 两个队列
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
