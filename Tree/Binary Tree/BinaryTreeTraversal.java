
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

    // Preorder traversal
    static void preOrderTraversal(TreeNode curr) {
        if (curr == null) {
            return;
        }

        System.out.print(curr.data + " ");
        preOrderTraversal(curr.left);
        preOrderTraversal(curr.right);
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

    public static void main(String[] args) {
        // List<Integer> preorder = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        inOrderTraversal(root);
        System.out.println();

        preOrderTraversal(root);
        System.out.println();

        postOrderTraversal(root);
    }
}
