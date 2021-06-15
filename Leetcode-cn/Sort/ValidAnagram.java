package Sort;

import java.util.Arrays;

/**
 * @Author: zhouhanming
 * @Date:2021/6/8 9:22 上午
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 有效的字母异位词，
 * 思路：哈希表，计数排序， 排序再比较
 *
 * 五毒神掌：
 * 第二遍：2021/6/14
 * 第三遍：2021/6/15
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
