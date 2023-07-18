


public class LinkedList{

    // Nested Node class to represent the nodes of the linked list
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Head, tail, and size variables to maintain the state of the linked list
    public static Node head;
    public static Node tail;
    public static int size;


    // ADD OPERATIONS
    // --------------
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
        tail = newNode;   // Update the tail to the new node
    }

    // Method to add a node with given data at the specified index in the linked list
    public void addInMiddle(int ind, int data){

        if(ind == 0){
            addFirst(data);  // If the index is 0, call addFirst method to add at the beginning
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;  // Store head to the temp
        int i = 0;

        while(i < ind - 1){  // Traverse the linked list until the node at index (ind - 1)
            temp = temp.next;  // Move temp to the next node
            i++;  // Increase i
        }

        // Set the new node's next reference to the current node at index (ind - 1)'s next node
        newNode.next = temp.next;  
        temp.next = newNode;  // Set the current node at index (ind - 1)'s next reference to the new node
    }

    // DELETE OR REMOVE OPERATIONS
    // ---------------------------
    public int removeFirst(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // ll.printList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        // ll.printList();

        // ll.addInMiddle(2, 5);
        // ll.printList();

        ll.printList();
        System.out.println(size);

        System.out.println(ll.removeFirst());
        ll.printList();
        System.out.println(size);

        System.out.println(ll.removeLast());
        ll.printList();
        System.out.println(size);
    }
}