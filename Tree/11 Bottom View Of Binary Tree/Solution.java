import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int val;
    Node left;
    Node right;

    Node(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

class Tuple {
    Node node;
    int row;

    Tuple(Node node, int row) {
        this.node = node;
        this.row = row;
    }
}

public class Solution {
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Tuple> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple tup = q.poll();
            Node node = tup.node;
            int x = tup.row;

            map.put(x, node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(bottomView(root));
    }
}