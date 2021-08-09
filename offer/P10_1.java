/**
 * @(#)P10_1.java, Aug 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author zhouhanming
 * easy - 一次过
 * 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/submissions/
 */
public class P10_1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] fibs = new int[n + 1];
        fibs[1] = 1;
        fibs[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]) % 1000000007;
        }

        return fibs[n];
    }
}