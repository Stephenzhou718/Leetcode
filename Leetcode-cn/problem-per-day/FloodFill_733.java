import java.util.Arrays;

/**
 * @Author: zhouhanming
 * @Date:2020/8/16 9:37 下午
 * 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class FloodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return new int[0][0];
        }
        if (image[sr][sc] == newColor) {
            return image;
        }

        updatePixel(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void updatePixel(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int rowNum = image.length;
        int colNum = image[0].length;
        if (sr < 0 || sr  > rowNum - 1 || sc < 0 || sc > colNum - 1) {
            return;
        }

        if (image[sr][sc]  == oldColor) {
            image[sr][sc] = newColor;
            updatePixel(image, sr - 1, sc, oldColor, newColor);
            updatePixel(image, sr + 1, sc, oldColor, newColor);
            updatePixel(image, sr, sc - 1, oldColor, newColor);
            updatePixel(image, sr, sc + 1, oldColor, newColor);
        }
    }
}
