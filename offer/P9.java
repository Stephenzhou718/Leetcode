/**
 * @(#)P9.java, Aug 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Stack;

/**
 * @author zhouhanming
 * easy - 一遍过
 * 两个栈实现一个队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class P9 {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public P9() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.size() == 0) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }
        }

        return s2.size() == 0 ? -1 : s2.pop();
    }
}