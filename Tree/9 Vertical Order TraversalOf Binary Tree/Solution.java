import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class Solution {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int x = tup.row;
            int y = tup.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(verticalTraversal(root));
    }
}