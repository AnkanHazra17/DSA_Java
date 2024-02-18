
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

    // This method calculates the height of the binary tree rooted at 'root' and
    // updates the diameter of the tree.
    static int height(TreeNode root, int[] diameter) {

        // If the current node is null (reached the leaf or an empty subtree), return 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees.
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        // Update the diameter with the maximum diameter considering the current
        // subtree.
        diameter[0] = Math.max(diameter[0], lh + rh);

        // Return the height of the current subtree.
        return 1 + Math.max(lh, rh);
    }

    // This method calculates and returns the diameter of the binary tree.
    static int diameterOfBinaryTree(TreeNode root) {

        // Create an array to hold the diameter value. Using an array to pass by
        // reference.
        int[] diameter = new int[1];

        // Call the height method to calculate the height of the tree and update the
        // diameter.
        height(root, diameter);

        // Return the calculated diameter of the binary tree.
        return diameter[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(diameterOfBinaryTree(root));
    }
}