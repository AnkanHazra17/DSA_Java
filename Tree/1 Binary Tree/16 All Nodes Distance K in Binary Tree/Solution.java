import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.w3c.dom.Node;

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

    static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (parent.left != null) {
                parentTrack.put(parent.left, parent);
                q.offer(parent.left);
            }
            if (parent.right != null) {
                parentTrack.put(parent.right, parent);
                q.offer(parent.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        q.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while (!q.isEmpty()) {
            if (currLevel == k) {
                break;
            }

            int size = q.size();
            currLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // case 1
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }

                // case 2
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }

                // case 3
                if (parentTrack.get(curr) != null && visited.get(parentTrack.get(curr)) == null) {
                    q.offer(parentTrack.get(curr));
                    visited.put(parentTrack.get(curr), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(distanceK(root, root.left, 2));

    }
}