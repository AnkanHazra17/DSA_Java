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

    public static void inOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inorder);
        inorder.add(root.val);
        inOrder(root.right, inorder);

    }

    public static int kthSmallest(TreeNode root, int k) {
        // List<Integer> inorder = new ArrayList<>();
        // inOrder(root, inorder);
        // return inorder.get(k - 1);
        TreeNode node = kthSmallestOpt(root, k);
        return node.val;
    }

    public static TreeNode kthSmallestOpt(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestOpt(root.left, k);

        if (left != null) {
            return left;
        }
        k--;
        if (k == 0) {
            return root;
        }

        return kthSmallestOpt(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1));

        // System.out.println(kthSmallestOpt(root, 1).val);
    }
}