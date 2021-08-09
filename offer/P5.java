/**
 * @(#)P5.java, Aug 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author zhouhanming
 * easy - 一次过
 * 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class P5 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // init char arr
        char[] originCharArr = s.toCharArray();
        char[] newCharArr;

        int blankSpaceCount = 0;
        for (char ch : originCharArr) {
            if (ch == ' ') {
                blankSpaceCount++;
            }
        }

        newCharArr = new char[s.length() + blankSpaceCount * 2];


        // transfer
        int i = originCharArr.length - 1;
        int j = newCharArr.length - 1;

        while (i >= 0 && j >= 0) {
            if (originCharArr[i] != ' ') {
                newCharArr[j--] = originCharArr[i--];

            } else {
                newCharArr[j--] = '0';
                newCharArr[j--] = '2';
                newCharArr[j--] = '%';
                i--;
            }
        }

        return new String(newCharArr);

    }
}