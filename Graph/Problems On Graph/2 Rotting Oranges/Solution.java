import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Solution {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;

        Queue<Pair> q = new LinkedList<>();

        // Create Visited Matrix
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        int tm = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm, t);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                    q.offer(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != countFresh) {
            return -1;
        }

        return tm;
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 1, 1 }, { 1, 1, 0 }, { 1, 1, 1 } };
        System.out.println(orangesRotting(arr));
    }
}