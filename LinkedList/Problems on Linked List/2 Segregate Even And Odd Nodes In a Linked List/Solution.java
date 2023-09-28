

// Question: Segregate Even and Odd Node

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


    public Node segregateEvenOdd(Node head) {

        // Check if the input linked list is empty or has only one node
        if (head == null || head.next == null) {
            return head;  // In such cases, no modification is needed, so return the original head
        }

        // Initialize two pointers, evHead and odHead, to track the heads of even and odd sublists
        Node evHead = head;
        Node odHead = head;

        // Find the first even element in the list, updating the evHead pointer
        while (evHead.data % 2 != 0) {
            evHead = evHead.next;
        }

        // Find the first odd element in the list, updating the odHead pointer
        while (odHead.data % 2 == 0) {
            odHead = odHead.next;
        }

        // Create two pointers, even and odd, to build the segregated list
        Node even = evHead;
        Node odd = odHead;
        Node temp = head;

        // Traverse the list from the third node onwards to segregate even and odd elements
        while (temp.next != null) {
            temp = temp.next;

            // If the current node's data is even, append it to the even sublist
            if (temp.data % 2 == 0) {
                even.next = temp;
                even = temp;
            } else {
                // If the current node's data is odd and it's not the same as the current odd head
                if (odHead != temp) {
                    // Append it to the odd sublist and update the odd pointer
                    odd.next = temp;
                    odd = temp;
                }
            }

        }

        // Connect the even and odd sublists by making the last even node point to the first odd node
        even.next = odHead;

        // Return the new head of the segregated list (evHead)
        return evHead;
    }

    
}

public class Solution {

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(4);
        ll.addLast(7);

        ll.printList();
        ll.segregateEvenOdd(ll.head);
        ll.printList();
    }
}