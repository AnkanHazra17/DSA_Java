import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

public class BinaryTreeTraversal {

    // Inorder traversal
    static void inOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inOrderTraversal(curr.left);
        System.out.print(curr.data + " ");
        inOrderTraversal(curr.right);
    }

    // Recursive Preorder traversal
    static void preOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        System.out.print(curr.data + " ");
        preOrderTraversal(curr.left);
        preOrderTraversal(curr.right);
    }

    // Itrative preorderTraversal
    static List<Integer> itrativePreorder(TreeNode root) {

        // Create a list to store the result of iterative preorder traversal
        List<Integer> list = new ArrayList<>();

        // Create a stack to simulate the recursive call stack
        Stack<TreeNode> st = new Stack<>();

        // Check if the root is null, and if so, return an empty list
        if (root == null) {
            return null;
        }

        // Push the root node onto the stack to start the traversal
        st.push(root);

        // Continue traversal until the stack is empty (all nodes are processed)
        while (!st.isEmpty()) {

            // Pop the top node from the stack and add its value to the result list
            root = st.pop();
            list.add(root.data);

            // Push the right child onto the stack if it exists (preorder: root, left,
            // right)
            if (root.right != null) {
                st.push(root.right);
            }

            // Push the left child onto the stack if it exists (preorder: root, left, right)
            if (root.left != null) {
                st.push(root.left);
            }
        }

        // Return the final result of iterative preorder traversal
        return list;
    }

    // Post order traversal
    static void postOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        postOrderTraversal(curr.left);
        postOrderTraversal(curr.right);
        System.out.print(curr.data + " ");
    }

    // Level Order Traversal(BFS)
    public static List<List<Integer>> levelOrder(TreeNode root) {

        // Create a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Create a list to store the result of level order traversal
        List<List<Integer>> list = new ArrayList<>();

        // Check if the root is null, and if so, return an empty list
        if (root == null) {
            return list;
        }

        // Enqueue the root node to start the traversal
        queue.offer(root);

        // Continue traversal until the queue is empty (all levels are processed)
        while (!queue.isEmpty()) {

            // Get the number of nodes at the current level
            int levelSize = queue.size();

            // Create a list to store values at the current level
            List<Integer> subList = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {

                // Enqueue left child if it exists
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                // Enqueue right child if it exists
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                // Add the value of the current node to the sublist and dequeue it
                subList.add(queue.poll().data);
            }

            // Add the sublist (values at the current level) to the result list
            list.add(subList);
        }

        // Return the final result of level order traversal
        return list;
    }

    public static void main(String[] args) {
        // List<Integer> preorder = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // inOrderTraversal(root);
        // System.out.println();

        // preOrderTraversal(root);
        // System.out.println();

        // postOrderTraversal(root);

        // System.out.println(levelOrder(root));

        System.out.println(itrativePreorder(root));
    }
}
