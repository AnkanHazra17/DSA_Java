
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

    public static boolean isSymmetricHelper(TreeNode leftSide, TreeNode rightSide) {
        if (leftSide == null || rightSide == null) {
            return leftSide == rightSide;
        }

        return (leftSide.val == rightSide.val) && isSymmetricHelper(leftSide.left, rightSide.right)
                && isSymmetricHelper(leftSide.right, rightSide.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(isSymmetric(root));
    }
}