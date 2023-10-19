
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

    // Function to totate a Lined list
    public static Node rotateRight(Node head, int k) {

        // Check if the input head is null, meaning there's no list to rotate.
        if (head == null) {
            return head;
        }

        // Check if there's only one node in the list, so rotation has no effect.
        if (head.next == null) {
            return head;
        }

        // Check if k is less than 1, meaning there's no need to rotate.
        if (k < 1) {
            return head;
        }

        // Calculate the length of the linked list.
        int length = findLength(head);
        // Calculate the effective rotation amount (k modulo length of the list).
        int ro = k % length;
        // Calculate the size of the sublist that will be rotated to the right.
        int size = length - ro;

        // If ro is 0, there is no need to rotate, so return the original list.
        if (ro == 0) {
            return head;
        }

        // Initialize two pointers, 'last' and 'temp', to traverse the list.
        Node last = head;
        Node temp = head;

        // Move 'last' to the node just before the rotation point.
        for (int i = 1; i < size; i++) {
            last = last.next;
        }

        // 'newHead' is the new head of the rotated list.
        Node newHead = last.next;
        // Set the 'last' node to point to null to disconnect the rotated part.
        last.next = null;

        // Traverse to the end of the rotated part to find its last node.
        Node newtemp = newHead;
        while (newtemp.next != null) {
            newtemp = newtemp.next;
        }

        // Connect the last node of the rotated part to the original list.
        newtemp.next = temp;

        // Return the new head of the rotated list.
        return newHead;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        // head = insertNode(head, 3);
        // head = insertNode(head, 4);
        // head = insertNode(head, 5);

        System.out.println("Printing original list");
        printLinkedList(head);

        Node newHead = rotateRight(head, 4);
        System.out.println("After rotating");
        printLinkedList(newHead);
    }
}