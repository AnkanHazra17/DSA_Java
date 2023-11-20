
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

    // This method checks if two binary trees represented by the root nodes 'p' and
    // 'q' are structurally identical.
    static boolean isSameTree(TreeNode p, TreeNode q) {

        // If either of the nodes is null, return true if both are null (indicating
        // equality), else return false.
        if (p == null || q == null) {
            return (p == q);
        }

        // Check if the current nodes have the same data and recursively compare their
        // left and right subtrees.
        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        System.out.println(isSameTree(root1, root2));
    }
}