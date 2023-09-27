

// Question: Odd Even Linked List
// Link: https://leetcode.com/problems/odd-even-linked-list/

class LinkedListLL{
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printList(){
        Node temp = head;  // Store head to the temp

        while(temp != null){  // Traversethe list untill null is occured
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move temp to the next node
        }
        System.out.println("null"); 
    }
    

    // Function For Odd-Even
    public Node oddEvenList(Node head){

        // Check if the input list is empty or has only one node
        if(head == null || head.next == null){
            return head;   // If so, no rearrangement needed, return the input list
        }

        // Initialize pointers for odd and even nodes, and a pointer for the head of the even nodes

        Node odd = head;           // Pointer for odd-indexed nodes (initially points to the first node)
        Node even = head.next;     // Pointer for even-indexed nodes (initially points to the second node)
        Node evHead = head.next;   // Pointer to the head of the even-indexed nodes

        // Traverse the list while there are still even and even.next nodes to process
        while(even != null && even.next != null){

            // Update the 'next' pointer of the odd node to skip the next node (moving to the next odd node)
            odd.next = odd.next.next;
            odd = odd.next;

            // Update the 'next' pointer of the even node to skip the next node (moving to the next even node)
            even.next = even.next.next;
            even = even.next;
        }

        // Connect the last odd node to the head of the even nodes
        odd.next = evHead;

        // Return the modified list with odd nodes followed by even nodes
        return head;
    }
}


public class Solution{

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();

        ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(3);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(4);
        // ll.addLast(7);

        ll.printList();

        ll.oddEvenList(ll.head);
        ll.printList();
    }
}