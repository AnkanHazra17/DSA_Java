
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

class Info {
    int maxi;
    int mini;
    int size;
    boolean isBST;

    Info(int maxi, int mini, int size, boolean isBST) {
        this.maxi = maxi;
        this.mini = mini;
        this.size = size;
        this.isBST = isBST;
    }
}

public class Solution {

    public static Info helper(TreeNode root, int[] ans) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }

        Info left = helper(root.left, ans);
        Info right = helper(root.right, ans);

        int size = left.size + right.size + 1;
        int maxValue = Math.max(root.data, right.maxi);
        int minValue = Math.min(root.data, left.mini);
        boolean isBST;

        if (left.isBST && right.isBST && (left.maxi < root.data && root.data < right.mini)) {
            isBST = true;
        } else {
            isBST = false;
        }

        Info currentNode = new Info(maxValue, minValue, size, isBST);

        if (currentNode.isBST == true) {
            ans[0] = Math.max(ans[0], currentNode.size);
        }

        return currentNode;
    }

    public static int largestBST(TreeNode root) {
        int[] ans = new int[1];
        Info temp = helper(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(largestBST(root));
    }
}