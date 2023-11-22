import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // Check if a given TreeNode is a leaf node
    static boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    // Add the values of non-leaf nodes in the left boundary of the tree to the
    // result list
    static void addLeftNodes(TreeNode node, List<Integer> res) {
        TreeNode curr = node.left;

        // Traverse the left boundary until reaching a leaf node
        while (curr != null) {

            // Add non-leaf nodes to the result list
            if (isLeaf(curr) == false) {
                res.add(curr.data);
            }

            // Move to the left child if available, otherwise move to the right child
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Add the values of non-leaf nodes in the right boundary of the tree to the
    // result list
    static void addRightNodes(TreeNode node, List<Integer> res) {
        TreeNode curr = node.right;
        Stack<Integer> st = new Stack<>();

        // Traverse the right boundary until reaching a leaf node
        while (curr != null) {

            // Add non-leaf nodes to a stack (later to be added in reverse order to the
            // result list)
            if (isLeaf(curr) == false) {
                st.push(curr.data);
            }

            // Move to the right child if available, otherwise move to the left child
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // Pop values from the stack and add them to the result list to maintain the
        // correct order
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
    }

    // Add the values of leaf nodes in the tree to the result list
    static void addLeafNodes(TreeNode node, List<Integer> res) {
        // Add the values of leaf nodes in the tree to the result list
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        // Recursively traverse the left and right subtrees to find leaf nodes
        if (node.left != null) {
            addLeafNodes(node.left, res);
        }

        if (node.right != null) {
            addLeafNodes(node.right, res);
        }
    }

    // Main function to traverse the boundary of a binary tree
    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // If the root is not a leaf, add its value to the result list
        if (isLeaf(root) == false) {
            ans.add(root.data);
        }

        // Add the left boundary nodes (excluding the root) to the result list
        addLeftNodes(root, ans);

        // Add the leaf nodes to the result list
        addLeafNodes(root, ans);

        // Add the right boundary nodes (excluding the root) to the result list
        addRightNodes(root, ans);

        // Return the final result list containing the boundary values of the binary
        // tree
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(traverseBoundary(root));
    }
}