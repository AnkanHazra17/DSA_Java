
// Question: Add Two Numbers
// Problem Link: https://leetcode.com/problems/add-two-numbers/description/

class LinkedListLL {
    static class Node {
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

    public static void printListUHead(Node head){
        Node temp = head; // Store head to the temp

        while (temp != null) { // Traversethe list untill null is occured
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move temp to the next node
        }
        System.out.println("null");
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        // Initialize a dummy node to store the result, initially set to 0.
        Node ans = new Node(0);
        Node temp = ans;  // Create a temporary pointer to traverse the result list.

        int carry = 0;  // Initialize a variable to keep track of the carry during addition.

        // Loop until both input linked lists are exhausted and there's no carry left.
        while(l1 != null || l2 != null || carry > 0){

            // Initialize a variable to store the sum of current digits.
            int sum = 0;

            // Add the value of the current node from l1 to the sum (if not null).
            if(l1 != null){
                sum = sum + l1.data;
                l1 = l1.next;
            }

            // Add the value of the current node from l2 to the sum (if not null).
            if(l2 != null){
                sum = sum + l2.data;
                l2 = l2.next;
            }

            // Add any carry from the previous iteration to the sum.
            sum = sum + carry;
            carry = sum / 10;  // Calculate the new carry for the next iteration.

            // Create a new node with the last digit of the sum.
            Node newNode = new Node(sum % 10);

            temp.next = newNode;   // Connect the new node to the result list.
            temp = temp.next;    // Move the temporary pointer to the newly added node.
        }

        // Return the result linked list, excluding the initial dummy node.
        return ans.next;
    }
}

public class Solution{

    public static void main(String[] args) {
        LinkedListLL l1 = new LinkedListLL();
        l1.addLast(9);
        l1.addLast(9);
        l1.addLast(9);
        l1.addLast(9);
        l1.addLast(9);
        l1.addLast(9);
        l1.addLast(9);

        LinkedListLL l2 = new LinkedListLL();
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);

        l1.printList();
        l2.printList();

        LinkedListLL.Node result = LinkedListLL.addTwoNumbers(l1.head, l2.head);
        LinkedListLL.printListUHead(result);
    } 
}