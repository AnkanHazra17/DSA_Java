
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    public static Node insertNode(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static void printLinkedList(Node head) {
        while (head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    static int findLength(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Function to reverse group of nodes
    static Node reverseKGroup(Node head, int k) {

        // Check if the input head is null or if there is only one node, in which case
        // no reversal is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Calculate the length of the linked list.
        int length = findLength(head);

        // Create a dummy node to simplify the reversal process, and set it to point to
        // the original head.
        Node dummy = new Node(0);
        dummy.next = head;

        // Initialize three pointers, 'pre', 'curr', and 'nex', to facilitate the
        // reversal.
        Node pre = dummy;
        Node curr;
        Node nex;

        // Continue reversing the linked list in groups of 'k' as long as there are 'k'
        // or more nodes remaining.
        while (length >= k) {
            // Initialize 'curr' to the current position, and 'nex' to the next node.
            curr = pre.next;
            nex = curr.next;

            // Reverse the 'k' nodes in the current group.
            for (int i = 1; i < k; i++) {
                curr.next = nex.next; // Adjust the 'curr' node to skip 'nex'.
                nex.next = pre.next; // 'nex' becomes the new head of the group.
                pre.next = nex; // Adjust 'pre' to point to the new head.
                nex = curr.next; // Move 'nex' to the next node in the group.
            }

            // Move 'pre' to the end of the current group to prepare for the next iteration.
            pre = curr;
            // Update the remaining length by subtracting 'k'.
            length = length - k;
        }

        // Return the head of the reversed list (linked to the dummy node).
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 6);
        head = insertNode(head, 7);
        head = insertNode(head, 8);

        System.out.println("Original Linked list");
        printLinkedList(head);

        Node newHead = reverseKGroup(head, 2);
        System.out.println("After revercing");
        printLinkedList(newHead);

    }
}