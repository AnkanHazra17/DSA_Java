

public class LinkedList{

    // Nested Node class to represent the nodes of the linked list
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Head and tail variables to maintain the state of the linked list
    static Node head;
    static Node tail;

    // Function to check if there is a cycle in a linked list
    static boolean isCycle(){

        // Initialize two pointers, slow and fast, both starting from the head of the linked list
        Node slow = head;
        Node fast = head;

        // Traverse the linked list using two pointers until the fast pointer reaches the end of the list
        // or encounters a null reference, which means there is no cycle
        while(fast != null && fast.next != null){

            // Move the slow pointer one step forward
            slow = slow.next;
            // Move the fast pointer two steps forward
            fast = fast.next.next;

            // If the slow pointer and the fast pointer meet at the same node, it indicates a cycle in the list
            if(slow == fast){
                return true;  // Return true as a cycle is found
            }
        }

        return false;  // If the loop terminates without finding any cycle, return false
    }

    // Method to remove a cycle from a linked list
    static void removeCycle(){

        // Initialize two pointers, slow and fast, both starting from the head of the linked list
        Node slow = head;
        Node fast = head;
        // Initialize a boolean variable to keep track of whether a cycle is found or not
        boolean cycle = false;

        // Traverse the linked list using two pointers until the fast pointer reaches the end of the list
        // or encounters a null reference, which means there is no cycle
        while(fast != null && fast.next != null){

            slow = slow.next;   // Move the slow pointer one step forward
            fast = fast.next.next;  // Move the fast pointer two steps forward

            // If the slow pointer and the fast pointer meet at the same node, it indicates a cycle in the list
            if(slow == fast){
                cycle = true;  // Set the 'cycle' flag to true to indicate that a cycle is found
                break;  // Break out of the loop to stop further traversal
            }
        }

        // If no cycle is found, simply return, as there is nothing to remove
        if(cycle == false){
            return;
        }

        // Reset the slow pointer to the head of the list, while keeping the fast pointer where it is
        slow = head;
        Node prev = null;  // Initialize a reference to keep track of the node before the cycle's starting point

        // Traverse the linked list using both slow and fast pointers until they meet again
        // This ensures that the slow pointer will reach the starting point of the cycle
        while(slow != fast){

            prev = fast;  // Keep track of the previous node before the slow pointer moves forward

            // Move both pointers one step forward
            slow = slow.next;
            fast = fast.next;
        }

        // Now, 'slow' and 'fast' pointers meet at the starting point of the cycle
        // To remove the cycle, set the 'next' reference of the previous node (before the cycle) to null
        // This breaks the cycle and effectively removes it from the linked list
        prev.next = null;
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        temp.next = new Node(3);
        temp.next.next = new Node(4);
        temp.next.next.next = temp;

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}