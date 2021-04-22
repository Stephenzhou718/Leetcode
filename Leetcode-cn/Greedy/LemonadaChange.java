package Greedy;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:05 下午
 * https://leetcode-cn.com/problems/lemonade-change
 *
 * 思路：
 * 1. 贪心算法 (局部最优可以推导出全剧最优，找不出反例，贪心）,
 *
 * 五毒神掌：
 * 第二遍：2021/4/21
 * 第三遍：2021/4/22
 */
public class LemonadaChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (ten > 0 & five > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
