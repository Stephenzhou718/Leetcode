/**
 * @(#)TwoSum_167.java, 7月 20, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
/**
 * @author zhouhanming
 * leetocde-cn 第 167 题
 * 两书之和
 */
public class TwoSum_167 {

    public static void main(String[] args) {
        System.out.println(new TwoSum_167().twoSum(new int[]{2,7,10,15}, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[2];
        }

        int indexBegin = 0;
        int indexEnd = numbers.length - 1;
        int[] ret = new int[2];

        while (indexBegin < indexEnd) {
            if (numbers[indexBegin] + numbers[indexEnd] < target) {
                indexBegin++;
            } else if (numbers[indexBegin] + numbers[indexEnd] > target) {
                indexEnd--;
            } else {
                ret[0] = indexBegin + 1;
                ret[1] = indexEnd + 1;
                break;
            }
        }
        return ret;
    }
}