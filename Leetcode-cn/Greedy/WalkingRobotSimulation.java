package Greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhouhanming
 * @Date:2021/4/20 11:07 下午
 * https://leetcode-cn.com/problems/walking-robot-simulation
 *
 * 思路：
 * 1. 模拟
 *
 * 五毒神掌：
 * 第二遍：2021/4/21
 * 第三遍，2021/4/22
 */
public class WalkingRobotSimulation {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] abstacle : obstacles) {
            String abstacleStr = abstacle[0] + "_" + abstacle[1];
            obstacleSet.add(abstacleStr);
        }


        int ans = 0;
        int x = 0;
        int y = 0;
        int di = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    String positionStr = nx + "_" + ny;
                    if (obstacleSet.contains(positionStr)) {
                        break;
                    } else {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
