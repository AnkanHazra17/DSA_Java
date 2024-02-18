import java.util.ArrayList;
import java.util.List;

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

public class Solution {

    public static void rightSide(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(root.val);
        }

        rightSide(root.right, ans, level + 1);
        rightSide(root.left, ans, level + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSide(root, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(rightSideView(root));
    }
}