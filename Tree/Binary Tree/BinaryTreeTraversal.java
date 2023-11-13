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

    // Recursive Inorder traversal
    static void inOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inOrderTraversal(curr.left);
        System.out.print(curr.data + " ");
        inOrderTraversal(curr.right);
    }

    // Itrative Inorder Traversal
    static List<Integer> itartiveInorder(TreeNode root) {

        // Create a stack to store tree nodes.
        Stack<TreeNode> st = new Stack<>();

        // Create a List to store the inorder traversal result.
        List<Integer> inorder = new ArrayList<>();

        // Start from the root of the tree.
        TreeNode node = root;

        // Infinite loop to traverse the tree until all nodes are processed.
        while (true) {

            // If the current node is not null, push it onto the stack and move to its left
            // child.
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                // If the current node is null, check if the stack is empty.
                // If the stack is empty, break out of the loop as traversal is complete.
                if (st.isEmpty()) {
                    break;
                }
                // If the stack is not empty, pop a node from the stack, add its value to the
                // inorder list,
                // and move to its right child.
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }

        // Return the List containing the inorder traversal result.
        return inorder;
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

    // Recursive Post order traversal
    static void postOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        postOrderTraversal(curr.left);
        postOrderTraversal(curr.right);
        System.out.print(curr.data + " ");
    }

    // Itrative Post Order Traversal --> using 2 Stack
    static List<Integer> itraPostorder2Stack(TreeNode root) {

        // Create two stacks for iterative traversal and a list to store the result
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postorder = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return postorder;
        }

        // Push the root node onto the first stack
        st1.push(root);

        // Start the first phase of traversal using the first stack
        while (!st1.isEmpty()) {

            // Pop a node from the first stack and push it onto the second stack
            root = st1.pop();
            st2.push(root);

            // Push the left child and then the right child onto the first stack
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        // Start the second phase of traversal using the second stack
        while (!st2.isEmpty()) {

            // Pop nodes from the second stack and add their data to the result list
            postorder.add(st2.pop().data);
        }

        // Return the list containing the postorder traversal
        return postorder;
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

        // System.out.println(itrativePreorder(root));

        // System.out.println(itartiveInorder(root));

        System.out.println(itraPostorder2Stack(root));
    }
}
