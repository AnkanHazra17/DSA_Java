
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int rootVal = root.val;

        if (rootVal > p.val && rootVal > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (rootVal < p.val && rootVal < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(lowestCommonAncestor(root, root.right, root.left.right).val);

    }
}