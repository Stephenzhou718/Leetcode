import java.util.*;

/**
 * @Author: zhouhanming
 * @Date:2020/8/13 8:47 下午
 * 两个数组的交集
 */
public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ret = new int[Math.max(nums1.length, nums2.length)];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int value : nums1) set1.add(value);
        for (int value : nums2) set2.add(value);


        int idx = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                ret[idx++] = num;
            }
        }
        return Arrays.copyOf(ret, idx);
    }
}
