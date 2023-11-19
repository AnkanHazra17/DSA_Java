
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

public class Solution {

    static int height(TreeNode root) {

        // Base case: if the current node is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int leftHalf = height(root.left);

        // If the left subtree is unbalanced, propagate the unbalance (-1) up the
        // recursion stack
        if (leftHalf == -1) {
            return -1;
        }

        // Recursively calculate the height of the right subtree
        int rightHalf = height(root.right);

        // If the right subtree is unbalanced, propagate the unbalance (-1) up the
        // recursion stack
        if (rightHalf == -1) {
            return -1;
        }

        // Check if the absolute difference between the heights of left and right
        // subtrees is greater than 1
        if (Math.abs(leftHalf - rightHalf) > 1) {
            return -1;
        }

        // Return 1 plus the maximum height of the left and right subtrees
        return 1 + Math.max(leftHalf, rightHalf);
    }

    static boolean isBalancedBinaryTree(TreeNode root) {

        // Check if the height of the tree is not -1 (indicating a balanced tree)
        return height(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.right = new TreeNode(6);

        System.out.println(isBalancedBinaryTree(root));
    }
}