
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

    static int heighOfBinaryTree(TreeNode root) {

        // Base case: if the current node is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int leftHalf = heighOfBinaryTree(root.left);

        // Recursively calculate the height of the right subtree
        int rightHalf = heighOfBinaryTree(root.right);

        // Return 1 plus the maximum height of the left and right subtrees
        return 1 + Math.max(leftHalf, rightHalf);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(heighOfBinaryTree(root));
    }
}