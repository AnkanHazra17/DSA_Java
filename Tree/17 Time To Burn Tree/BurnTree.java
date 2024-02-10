import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class BurnTree {
    public static BinaryTreeNode<Integer> parentList(BinaryTreeNode<Integer> root,
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap, int target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        BinaryTreeNode<Integer> res = new BinaryTreeNode<Integer>(-1);

        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node.data == target) {
                res = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        return res;
    }

    public static int findMinTime(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentList,
            BinaryTreeNode<Integer> target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
        int minTime = 0;
        q.offer(target);
        visited.put(target, true);

        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = q.poll();

                // case 1
                if (node.left != null && visited.get(node.left) == null) {
                    flag = 1;
                    q.offer(node.left);
                    visited.put(node.left, true);
                }

                // case 2
                if (node.right != null && visited.get(node.right) == null) {
                    flag = 1;
                    q.offer(node.right);
                    visited.put(node.right, true);
                }

                // case 3
                if (parentList.get(node) != null && visited.get(parentList.get(node)) == null) {
                    flag = 1;
                    q.offer(parentList.get(node));
                    visited.put(parentList.get(node), true);
                }
            }
            if (flag == 1) {
                minTime++;
            }
        }
        return minTime;
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        BinaryTreeNode<Integer> target = parentList(root, parentMap, start);
        int min = findMinTime(parentMap, target);
        return min;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        root.left = new BinaryTreeNode<Integer>(2);
        root.right = new BinaryTreeNode<Integer>(3);
        root.left.left = new BinaryTreeNode<Integer>(4);
        root.left.left.right = new BinaryTreeNode<Integer>(8);
        root.left.right = new BinaryTreeNode<Integer>(5);
        root.right.left = new BinaryTreeNode<Integer>(6);
        root.right.right = new BinaryTreeNode<Integer>(7);
        System.out.println(timeToBurnTree(root, 2));
    }
}