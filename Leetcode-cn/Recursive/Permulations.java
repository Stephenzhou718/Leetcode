package Recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/14 11:01 下午
 * https://leetcode-cn.com/problems/permutations/
 * 参考题解(里面总结了知识点)：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 * 思路：
 * dfs：时间复杂度 O(nk), 空间复杂度 O(n)
 *
 * 五毒神掌：
 * 第二遍，2021/3/14
 * 第三遍，2021/4/8
 */
public class Permulations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, nums.length, 0, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
