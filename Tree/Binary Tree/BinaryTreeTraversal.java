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

class Pair {
    int num;
    TreeNode node;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
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

    // Itrative Post Order Traversal --> using 1 stack
    static List<Integer> itraPostorder1Stack(TreeNode root) {

        // List to store the result of postorder traversal
        List<Integer> postorder = new ArrayList<>();

        // Stack to simulate recursion and store nodes
        Stack<TreeNode> st = new Stack<>();

        // Check if the tree is empty
        if (root == null) {
            return postorder; // Return an empty list if the tree is empty
        }

        // Initialize current node to the root of the tree
        TreeNode curr = root;

        // Continue traversal until current node is null and stack is empty
        while (curr != null || !st.isEmpty()) {

            // If current node is not null, push it onto the stack and move to its left
            // child
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {

                // If current node is null, process its right child and pop nodes
                TreeNode temp = st.peek().right;

                // If right child is null, process the node and its right subtree
                if (temp == null) {
                    temp = st.pop();
                    postorder.add(temp.data);

                    // Keep popping from the stack until a node with a right child is found
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        postorder.add(temp.data);
                    }
                } else {
                    // If right child is not null, move to the right child
                    curr = temp;
                }
            }
        }

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

    // Preorder inorder and postorder in one traversal
    static List<List<Integer>> preInPost(TreeNode root) {
        // Create a stack to perform iterative tree traversal using the Pair class to
        // store both the TreeNode and a number indicating the stage of traversal.
        Stack<Pair> st = new Stack<>();

        // Create lists to store the nodes visited during pre-order, in-order, and
        // post-order traversals.
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // Create a list to store the three traversal lists.
        List<List<Integer>> list = new ArrayList<>();

        // Check if the root is null. If so, return the empty list.
        if (root == null) {
            return list;
        }

        // Push the root node onto the stack with 'num' set to 1 to indicate the start
        // of traversal.
        st.push(new Pair(root, 1));

        // Start iterative traversal using the stack.
        while (!st.isEmpty()) {

            // Pop the top element from the stack.
            Pair p = st.pop();

            // Check the stage of traversal using 'num'.
            if (p.num == 1) {

                // If 'num' is 1, it means it's the first time visiting the node in pre-order
                // traversal.
                // Add the node's data to the pre-order list and update 'num' to 2.
                pre.add(p.node.data);
                p.num++;

                // Push the updated Pair back onto the stack to resume traversal after visiting
                // the left child.
                st.push(p);

                // If the left child exists, push it onto the stack with 'num' set to 1.
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            } else if (p.num == 2) {

                // If 'num' is 2, it means it's the second time visiting the node in in-order
                // traversal.
                // Add the node's data to the in-order list and update 'num' to 3.
                in.add(p.node.data);
                p.num++;

                // Push the updated Pair back onto the stack to resume traversal after visiting
                // the right child.
                st.push(p);

                // If the right child exists, push it onto the stack with 'num' set to 1.
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            } else {
                // If 'num' is 3, it means it's the third time visiting the node in post-order
                // traversal.
                // Add the node's data to the post-order list.
                post.add(p.node.data);
            }
        }

        // Add the three traversal lists to the final result list.
        list.add(pre);
        list.add(in);
        list.add(post);

        // Return the list containing pre-order, in-order, and post-order traversal
        // lists.
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

        // System.out.println(itraPostorder2Stack(root));
        // System.out.println(itraPostorder1Stack(root));

        System.out.println(preInPost(root));
    }
}
