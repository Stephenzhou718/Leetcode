/**
 * @(#)P3.java, Aug 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author zhouhanming
 * easy -
 * 数组中重复的数据
 * https://leetcode-cn.com/problem-list/xb9nqhhg/
 */
public class P3 {
    public int findRepeatNumber(int[] nums) {
        boolean[] numsRecord = new boolean[nums.length];

        for (int num : nums) {
            if (numsRecord[num]) {
                return num;
            } else {
                numsRecord[num] = true;
            }
        }

        return 0;
    }
}