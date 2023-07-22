

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
    static boolean isCycle(Node head){

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

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // head.next.next.next = head;

        System.out.println(isCycle(head));
    }
}