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

    public static int findSuccessor(TreeNode root, int key) {
        int successor = -1;
        while (root != null) {
            if (root.val <= key) {
                root = root.right;
            } else {
                successor = root.val;
                root = root.left;
            }
        }

        return successor;
    }

    public static int findPredecessor(TreeNode root, int key) {
        int predecessor = -1;
        while (root != null) {
            if (root.val < key) {
                predecessor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return predecessor;
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        int successor = findSuccessor(root, key);
        int predecessor = findPredecessor(root, key);
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }

    public static void main(String[] args) {

    }
}