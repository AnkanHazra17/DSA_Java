import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Create a queue to perform level order traversal
        Queue<TreeNode> qu = new LinkedList<>();

        // Create a list to store the result
        List<List<Integer>> list = new ArrayList<>();

        // Check if the root is null, return an empty list
        if (root == null) {
            return list;
        }

        // Boolean flag to determine the direction of traversal (left to right or right
        // to left)
        boolean flag = true;

        // Enqueue the root node to start the traversal
        qu.offer(root);

        // Perform level order traversal
        while (!qu.isEmpty()) {

            // Get the number of nodes at the current level
            int levelNum = qu.size();

            // List to store the values of nodes at the current level
            List<Integer> sublist = new ArrayList<>();

            // Iterate through the nodes at the current level
            for (int i = 0; i < levelNum; i++) {

                // Enqueue the left child if it exists
                if (qu.peek().left != null) {
                    qu.offer(qu.peek().left);
                }

                // Enqueue the right child if it exists
                if (qu.peek().right != null) {
                    qu.offer(qu.peek().right);
                }

                // Add the value of the current node to the sublist based on the flag
                if (flag == true) {
                    sublist.add(qu.poll().data);
                } else {
                    sublist.add(0, qu.poll().data);
                }
            }

            // Invert the flag to change the direction for the next level
            flag = !flag;

            // Add the sublist for the current level to the result list
            list.add(sublist);
        }

        // Return the final result list
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(zigzagLevelOrder(root));
    }
}