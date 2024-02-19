
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

    public static TreeNode buildFromPreorder(int[] A, int bound, int[] i) {
        if (i[0] == A.length || A[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = buildFromPreorder(A, root.val, i);
        root.right = buildFromPreorder(A, bound, i);

        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return buildFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        System.out.println(bstFromPreorder(preorder).val);
    }
}