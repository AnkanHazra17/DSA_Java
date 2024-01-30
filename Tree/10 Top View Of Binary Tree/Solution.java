import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

class Tuple {
    TreeNode node;
    int row;

    Tuple(TreeNode node, int row) {
        this.node = node;
        this.row = row;
    }
}

public class Solution {

    static ArrayList<Integer> topView(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int x = tup.row;

            if (map.get(x) == null) {
                map.put(x, node.val);
            }

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
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

        System.out.println(topView(root));
    }
}