import java.util.HashMap;
import java.util.Map;

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

public class ConstTreeInPre {
    public static TreeNode buildTreeHelper(int[] preorder, int preSt, int preEnd, int[] inOrder, int inSt, int inEnd,
            Map<Integer, Integer> inMap) {
        if (preSt > preEnd || inSt > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preSt]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inSt;

        root.left = buildTreeHelper(preorder, preSt + 1, preSt + numsLeft, inOrder, inSt, inRoot - 1, inMap);
        root.right = buildTreeHelper(preorder, preSt + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 10, 20, 40, 50, 30, 60 };
        int[] inOrder = { 40, 20, 50, 10, 60, 30 };

        System.out.println(buildTree(preorder, inOrder).val);
    }
}