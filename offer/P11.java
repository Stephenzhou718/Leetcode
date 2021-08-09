/**
 * @(#)P11.java, Aug 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author zhouhanming
 * easy - 要多几遍 😭😭😭😭😭
 * 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class P11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int left = 0;
        int right = numbers.length -1 ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;

            } else if (numbers[mid] == numbers[right]) {
                right--;

            } else {
                right = mid;

            }
        }

        return numbers[left];

    }
}