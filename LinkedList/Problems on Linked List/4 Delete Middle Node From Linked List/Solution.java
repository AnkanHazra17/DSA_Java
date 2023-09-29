

// Question: Delete the Middle Node of a Linked List
//Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

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

    // Function to find the middle node of a singly linked list
    public Node findMiddle(Node head){

        // Initialize two pointers, 'slow' and 'fast,' both starting at the head of the list
        Node slow = head;
        Node fast = head;
        Node prev = null;  // Pointer prev --> set null

        // Traverse the list with 'fast' moving two steps at a time and 'slow' moving one step at a time
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' now points to the middle node, so return it
        return prev;
    }

    // Function to delete the middle node of a singly linked list
    public Node deleteMiddle(Node head) {

        // Check if the list is empty or has only one element
        if(head == null || head.next == null){
            return null;   // There's no middle node to delete
        }

        // Find the middle node using the 'findMiddle' function
        Node midNode = findMiddle(head);
        
        midNode.next = midNode.next.next;
        
        // Return the head of the modified list
        return head;
    }
}

public class Solution{

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();

        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(7);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(6);

        ll.printList();
        ll.deleteMiddle(ll.head);
        ll.printList();

    }
}