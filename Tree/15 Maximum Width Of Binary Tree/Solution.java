import java.util.LinkedList;
import java.util.Queue;

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

class Pair {
    TreeNode node;
    int ind;

    Pair(TreeNode node, int ind) {
        this.node = node;
        this.ind = ind;
    }
}

public class Solution {

    public static int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int fast = 0;
            int last = 0;
            int min = q.peek().ind;

            for (int i = 0; i < size; i++) {
                int curr_id = q.peek().ind - min;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) {
                    fast = curr_id;
                }

                if (i == size - 1) {
                    last = curr_id;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, curr_id * 2 + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, curr_id * 2 + 2));
                }
            }

            ans = Math.max(ans, last - fast + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println(widthOfBinaryTree(root));

    }
}