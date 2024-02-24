
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
    private static TreeNode first;
    private static TreeNode mid;
    private static TreeNode last;
    private static TreeNode prev;

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null && (prev.val > root.val)) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        prev = root;

        inOrder(root.right);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inOrder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val);
        printInorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        printInorder(root);
        recoverTree(root);
        printInorder(root);

    }
}