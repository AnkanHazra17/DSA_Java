

public class LinkedlistSort{

    // Nested Node class to represent the nodes of the linked list
    public static class Node{
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

    // Method to add a node with given data at the beginning of the linked list
    public void addFirst(int data){
        Node newNode = new Node(data);  // Create new node
        size++;   // Increase size

        // if LinkedList is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        newNode.next = head;  // Set the new node's next reference to the current head
        head = newNode;  // Update the head to the new node
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
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


    // Function to find the middle node of a linked list
    static Node findMid(Node head){

        // Two pointers 
        Node slow = head;  // points to head
        Node fast = head.next;  // points to head's next node

        // Using two pointers, 'slow' and 'fast', to find the middle node
        while(fast != null && fast.next != null){
            slow = slow.next;       // Move 'slow' by one step
            fast = fast.next.next;  // Move 'fast' by two steps
        }

        return slow;   // 'slow' will be pointing to the middle node
    }


    // Function to merge two sorted linked lists into a single sorted linked list
    static Node merge(Node first, Node second){

        Node mergedLl = new Node(-1);  // Create a dummy node to represent the merged linked list
        Node temp = mergedLl;    // Create a pointer 'temp' to traverse the merged linked list

        // Compare the elements from both linked lists and merge them in sorted order
        while(first != null && second != null){
            if(first.data <= second.data){
                temp.next = first;
                temp = temp.next;
                first = first.next;
            }
            else{
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }

        // If any elements are left in either of the original linked lists, append them to the merged list
        while(first != null){
            temp.next = first;
            temp = temp.next;
            first = first.next;
        }

        while(second != null){
            temp.next = second;
            temp = temp.next;
            second = second.next;
        }

        return mergedLl.next;  // Return the head of the merged linked list (skip the dummy node)
    }


    // Function to perform merge sort on a linked list
    static Node merrgeSort(Node head){

        // Base case: If the linked list is empty or has only one node, it is already sorted
        if(head == null || head.next == null){
            return head;
        }

        // Step: 1
        Node midNode = findMid(head);   // Find the middle node of the linked list

        // Step: 2 => Divide the LinkedList into two halves

        Node rightHead = midNode.next;  // Store the head of the right half of the linked list
        midNode.next = null;     // Disconnect the left and right halves of the linked list

        Node left = merrgeSort(head);   // Recursively sort the left half of the linked list
        Node right = merrgeSort(rightHead);  // Recursively sort the right half of the linked list

        return merge(left, right);   // Merge the sorted left and right halves and return the result
    }

    public static void main(String[] args) {
        LinkedlistSort ll = new LinkedlistSort();

        // ll.addLast(4);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(3);

        ll.addFirst(3);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(4);
        ll.printList();
        ll.merrgeSort(head);
        ll.printList();
    }
}