
// Custom exception class to represent the scenario when the stack is empty
class StackEmptyException extends Exception{

}

// Node class representing individual nodes in the linked list
class Node{
    int data;     // Data stored in the node
    Node next;    // Reference to the next node in the linked list

    // Constructor to create a node with given data
    public Node(int data){
        this.data = data;
        this.next = null;   // Initialize next to null as this is a new node
    }
}

// Stack implementation using a linked list
class StackLL{
    private Node head;    // Reference to the head (top) of the linked list
    private int size;     // Number of elements in the stack

    // Default constructor, initializes the stack with an empty linked list
    public StackLL(){
        this.head = null;    // Initially, the stack is empty, so the head is null
        this.size = 0;       // Initially, the stack size is 0
    }

    // Method to check if the stack is empty
    public boolean isEmpty(){
        return size == 0;   // Stack is empty when the size is 0
    }

    // Method to get the top element of the stack without removing it
    public int top(){
        return head.data;   // Return the data stored in the head node (top of the stack)
    }

    // Method to get the current size of the stack
    public int size(){
        return size;    // Return the number of elements in the stack
    }

    // Method to push an element onto the top of the stack
    public void push(int val){
        Node newNode = new Node(val);   // Create a new node with the given value
        size++;      // Increment the stack size

        if(head == null){   // If the stack is empty (head is null), make the new node the head
            head = newNode;
            return;
        }

        // If the stack is not empty, insert the new node at the top of the linked list
        newNode.next = head;   // Point the new node's next to the current head
        head = newNode;        // Update the head to the new node (new top of the stack)
    }

    // Method to pop (remove and return) the top element from the stack
    public int pop() throws StackEmptyException{
        if(size == 0){
            // If the stack is empty, throw a custom StackEmptyException
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        // If the stack has only one element, remove it and update the head to null
        else if(size == 1){
            int temp = head.data;    // Save the data in the current head
            head = null;             // Set head to null (stack becomes empty)
            size = 0;                // Update the size to 0
            return temp;             // Return the saved data (element popped)
        }

        // If the stack has more than one element, remove the current head and update the head to the next node
        int temp = head.data;      // Save the data in the current head
        head = head.next;          // Update head to the next node (new top of the stack)
        size--;                    // Decrement the stack size
        return temp;               // Return the saved data (element popped)

    }
}


public class StackUsingLL{

    public static void main(String[] args) {
        StackLL stack = new StackLL();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.top());
        System.out.println(stack.size());

        while(!stack.isEmpty()){
            try{
                System.out.println(stack.pop() + " ");
            }
            catch(StackEmptyException e){

            }
        }

    }
}