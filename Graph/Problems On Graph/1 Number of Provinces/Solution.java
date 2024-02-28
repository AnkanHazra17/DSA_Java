import java.util.ArrayList;

public class Solution {

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjls, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adjls.get(node)) {
            if (vis[it] == false) {
                dfs(it, adjls, vis);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjls = new ArrayList<>();
        int v = isConnected.length;

        for (int i = 0; i < v; i++) {
            adjls.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[v + 1];
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                cnt++;
                dfs(i, adjls, vis);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(arr));
    }
}