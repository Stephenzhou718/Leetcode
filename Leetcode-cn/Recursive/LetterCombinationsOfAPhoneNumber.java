package Recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhouhanming
 * @Date:2021/3/17 10:02 下午
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 思路：
 * 1. 排列组合的问题，明显就是回溯了：时间复杂度 O(3^n), 空间复杂度 O(logn)
 *
 * 五毒神掌：
 * 第二遍，2021/3/17
 * 第三遍，2021/4/17
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        Map<Character, String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0, sb, res, map);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res, Map<Character, String> map) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String numsStr = map.get(c);
        for (int i = 0; i < numsStr.length(); i++) {
            sb.append(numsStr.charAt(i));
            dfs(digits, index + 1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
