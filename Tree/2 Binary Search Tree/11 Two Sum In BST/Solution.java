import java.util.Stack;

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

class BSTItarator {
    Stack<TreeNode> st = new Stack<>();
    boolean isLeft;

    BSTItarator(TreeNode root, boolean isLeft) {
        this.isLeft = isLeft;
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);

            if (isLeft == true) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public int next() {
        TreeNode nxt = st.pop();

        if (isLeft == true) {
            pushAll(nxt.right);
        } else {
            pushAll(nxt.left);
        }

        return nxt.val;
    }
}

public class Solution {

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTItarator l = new BSTItarator(root, true);
        BSTItarator r = new BSTItarator(root, false);

        int start = l.next();
        int end = r.next();

        while (start < end) {
            if (start + end == k) {
                return true;
            }

            if (start + end < k) {
                start = l.next();
            } else {
                end = r.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 15));
    }
}