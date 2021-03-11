package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouhanming
 * @Date:2021/3/2 10:15 下午
 *
 * 解法：
 * 1. 双层循环: 时间复杂度 O(n^2), 空间复杂度 O(1)
 * 2. 哈希表法: 时间复杂度 O(n), 空间复杂度 O(n)
 *
 * 五毒神掌：第二遍，第三遍时间：2021/3/3
 * 五毒神掌：第三遍，第四遍时间：2021/3/10
 * 五毒神掌：第四遍，第五遍时间：
 */
public class TwoSum {

    // 暴力双层循环
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    // 哈希表法
    public static int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}
