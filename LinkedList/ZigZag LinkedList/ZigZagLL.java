



public class ZigZagLL{

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add a node with given data at the end of the linked list
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // If the linked list is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        tail.next = newNode;  // Set the current tail's next reference to the new node
        tail = newNode;       // Update the tail to the new node
    }

    // Method to print the elements of the linked list
    public void printList(){
        Node temp = head;  // Store head to the temp

        while(temp != null){  // Traversethe list untill null is occured
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move temp to the next node
        }
        System.out.println("null"); 
    }


    static void zigZag(){
        // Step-1: Find Mid
        Node slow = head;       // Initialize a pointer 'slow' to the head of the linked list.
        Node fast = head.next;  // Initialize a pointer 'fast' to the second node of the linked list.

        // Traverse the linked list with 'slow' moving one step and 'fast' moving two steps at a time,
        // until 'fast' reaches the end or the second-to-last node.
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;    // Now, 'mid' is pointing to the middle node of the linked list.

        // Step-2: Revers left half
        Node curr = mid.next;     // Start 'curr' from the node after 'mid' (second half of the list).
        mid.next = null;          // Break the link between the first and second halves.
        Node prev = null;         // Initialize a pointer 'prev' to null, which will be used in the reversal.
        Node aft;

        // Reverse the second half of the linked list.
        while(curr != null){
            aft = curr.next;      // Save the next node to be processed after 'curr'.
            curr.next = prev;     // Reverse the link of 'curr' to point to the previous node ('prev').
            prev = curr;          // Move 'prev' one step ahead to the current node 'curr'.
            curr = aft;           // Move 'curr' one step ahead to the next node to be processed.
        }


        // Now, 'prev' is pointing to the last node of the original linked list, which is the reversed first half.

        // Step-3: Merge in zigzag order or Alternate order
        Node left = head;      // Initialize a pointer 'left' to the head of the original linked list (first half).
        Node right = prev;     // Initialize a pointer 'right' to the last node of the reversed first half.

        Node nextL;
        Node nextR;

        // Merge the nodes in zigzag or alternate order.
        while(left != null && right != null){
            nextL = left.next;         // Save the next node of 'left' to be processed after merging.
            left.next = right;         // Make 'left' point to the current node of 'right'.
            nextR = right.next;        // Save the next node of 'right' to be processed after merging.
            right.next = nextL;        // Make 'right' point to the current node of 'left'.

            // Move 'left' and 'right' to their respective next nodes for the next iteration.
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printList();
        zigZag();
        ll.printList();
    }
}