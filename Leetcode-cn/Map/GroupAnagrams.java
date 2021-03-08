package Map;

import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2021/3/8 9:30 下午
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 思路：
 * 1. 暴力排序: 时间复杂度 O(nklogk), 空间复杂度 (nk)
 * 2. hashMap: 时间复杂度 O(nk), 空间复杂度 (nk)
 *
 * 五毒神掌: 第二遍，第三遍时间 2021/3/9
 */
public class GroupAnagrams {

    // 排序 + hashmap
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length  == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return new ArrayList<>(map.values());
    }

    // 位数组 + hashmap
    public List<List<String>> groupAnagrams_2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    keyBuilder.append((char) i + 'a');
                    keyBuilder.append(counts[i]);
                }
            }
            String key = keyBuilder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
