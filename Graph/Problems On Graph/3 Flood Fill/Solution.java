import java.util.Arrays;

public class Solution {

    public static void dfs(int[][] image, int[][] ans, int[] delRow, int[] delCol, int sr, int sc, int initColor,
            int newColor) {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor
                    && ans[nrow][ncol] != newColor) {
                dfs(image, ans, delRow, delCol, nrow, ncol, initColor, newColor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        dfs(image, ans, delRow, delCol, sr, sc, initColor, color);
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] result = floodFill(arr, 1, 1, 2);
        System.out.println(Arrays.toString(result));
    }
}