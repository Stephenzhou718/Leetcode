/**
 * @Author: zhouhanming
 * @Date:2020/8/16 11:26 下午
 * 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] == target) {
                left = mid + 1;
            }
        }

        return letters[left % letters.length];
    }
}
