package Recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/17 9:15 下午
 * https://leetcode-cn.com/problems/subsets/
 *
 * 思路：
 * 1. 回溯：时间复杂度 O(n2)
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, 0, tmp, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> tmp, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        dfs(nums, i + 1, tmp, res);
        tmp.add(nums[i]);
        dfs(nums,  i + 1, tmp, res);
        tmp.remove(tmp.size() - 1);
    }
}
