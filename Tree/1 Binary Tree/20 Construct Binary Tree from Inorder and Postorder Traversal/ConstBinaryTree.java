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

public class ConstBinaryTree {

    public static TreeNode buildTreeHelper(int[] postorder, int poSt, int poEnd, int[] inorder, int inSt, int inEnd,
            Map<Integer, Integer> inMap) {
        if (poSt > poEnd || inSt > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[poEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inSt;
        int numsRight = inEnd - inRoot;

        root.left = buildTreeHelper(postorder, poSt, poEnd - numsRight - 1, inorder, inSt, inRoot - 1, inMap);
        root.right = buildTreeHelper(postorder, poSt + numsLeft, poEnd - 1, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        System.out.println(buildTree(inorder, postorder).val);
    }
}