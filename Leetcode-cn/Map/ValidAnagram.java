package Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouhanming
 * @Date:2021/3/8 8:35 下午
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * 思路：
 * 1. 排序: 时间复杂度 O(NlogN), 空间复杂度 O(1)
 * 2. 哈希表: 时间复杂度 O(N), 空间复杂度 O(N)
 * 3. 26 位长的数组: 时间复杂度 O(N), 空间复杂度 O(26)
 *
 * 五毒神掌：第二遍，第三遍时间：2021/3/9
 */
public class ValidAnagram {

    // 暴力排序法
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    // hash 表
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.get(c) == null ? 0 : map.get(c);
            map.put(c, count + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
