
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

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;

        while (temp != null) {
            if (temp.val == val) {
                return temp;
            } else {
                if (temp.val > val) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(searchBST(root, 6));
    }
}