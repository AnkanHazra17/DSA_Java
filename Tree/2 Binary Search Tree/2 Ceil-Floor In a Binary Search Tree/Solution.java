
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
    public static int findCeil(TreeNode node, int x) {
        int ceil = -1;
        while (node != null) {
            if (node.val == x) {
                return x;
            }

            if (node.val < x) {
                node = node.right;
            } else {
                ceil = node.val;
                node = node.left;
            }
        }

        return ceil;
    }

    public static int findFloor(TreeNode node, int input) {
        int floor = -1;

        while (node != null) {
            if (node.val == input) {
                return input;
            }

            if (node.val < input) {
                floor = node.val;
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(findCeil(root, 9));
        System.out.println(findFloor(root, 6));
    }
}