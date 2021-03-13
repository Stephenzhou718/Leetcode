package Array;

import sun.management.snmp.jvmmib.EnumJvmClassesVerboseLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/3 10:51 下午
 * https://leetcode-cn.com/problems/3sum/
 *
 * 思路：
 * 1. 暴力三层循环: 时间复杂度 O(n^3), 空间复杂度 O(1)
 * 2. 双指针: 时间复杂度 O(n^2), 空间复杂度 O(1)
 *
 * 五毒神掌：第二遍，第三遍时间 2021/3/5
 * 五毒神掌：第三遍，第四遍时间 2021/3/12
 * 五毒神掌：第四遍，第五遍时间：
 *
 * 注意点：去除重复的 list
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k)
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;

                } else {
                    k--;
                }

        }
        return res;
    }
}
