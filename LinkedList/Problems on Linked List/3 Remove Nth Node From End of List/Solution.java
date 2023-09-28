

// Question: Remove Nth Node from the end of the Linked List
// Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


class LinkedListLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printList() {
        Node temp = head; // Store head to the temp

        while (temp != null) { // Traversethe list untill null is occured
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move temp to the next node
        }
        System.out.println("null");
    }

    public Node removeNthFromEnd(Node head, int n) {

        // Check if the linked list has only one node (head.next == null)
        if(head.next == null){
            return null;  // If it does, removing the only node results in an empty list
        }

        Node temp = head;  // Create a temporary node pointing to the head of the list
        int size = 0;      // Initialize a variable to keep track of the size of the list

        // Traverse the list to calculate its size
        while(temp.next != null){
            temp = temp.next;  // Move to the next node
            size++;   // Increment the size counter
        }

        // Check if the node to remove is the first node (n == size + 1)
        if(n == size + 1){
            head = head.next;   // Update the head to the second node, effectively removing the first node
            return head;        // Return the new head
        }

        int ind = size - n;   // Calculate the index of the node to remove from the beginning
        int cnt = 0;          // Initialize a counter to track the current node index
        temp = head;          // Reset the temporary node to the head of the list

        // Traverse the list again to find the node just before the one to remove
        while(cnt != ind){
            temp = temp.next;   // Move to the next node
            cnt++;     // Increment the counter
        }

        // Remove the nth node from the end by updating the next reference of the previous node
        temp.next = temp.next.next;
        return head;   // Return the head of the modified list
    }
}

public class Solution{

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();

        ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);

        ll.printList();

        ll.removeNthFromEnd(ll.head, 1);

        ll.printList();
    }
}