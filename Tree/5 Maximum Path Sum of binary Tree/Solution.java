
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
    // updates the maximum path sum.
    static int height(TreeNode root, int[] maxi) {

        // If the current node is null (reached the leaf or an empty subtree), return 0.
        if (root == null) {
            return 0;
        }

        // Calculate the maximum path sum for the left and right subtrees, considering
        // only positive contributions.
        int lh = Math.max(0, height(root.left, maxi));
        int rh = Math.max(0, height(root.right, maxi));

        // Update the maximum path sum by considering the current node's contribution
        // along with its subtrees.
        maxi[0] = Math.max(maxi[0], root.data + lh + rh);

        // Return the maximum path sum including the current node, considering the
        // positive contributions only.
        return root.data + Math.max(lh, rh);
    }

    // This method calculates and returns the maximum path sum of the binary tree.
    static int maxPathSum(TreeNode root) {

        // Create an array to hold the maximum path sum value. Using an array to pass by
        // reference.
        int[] maxi = new int[1];

        // Initialize the maximum path sum with the lowest possible integer value.
        maxi[0] = Integer.MIN_VALUE;

        // Call the height method to calculate the maximum path sum and update the
        // 'maxi' array.
        height(root, maxi);

        // Return the calculated maximum path sum of the binary tree.
        return maxi[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}