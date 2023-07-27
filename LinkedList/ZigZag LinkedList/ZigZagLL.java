



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
        tail = newNode;   // Update the tail to the new node
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

    // Method to find Mid 
    static Node findMid(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node reverseLL(Node lefthead){
        Node prev = null;
        Node curr = lefthead;
        Node aft;

        while(curr != null && curr.next != null){
            aft = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aft;
        }

        return prev;
    }

    static void zigZag(){
        // Step-1: Find Mid
        Node mid = findMid();

        // Step-2: Revers left half
        Node prev = reverseLL(mid);

        // Step-3: Merge in zigzag order or Alternate order
        Node left = head;
        Node right = prev;

        Node nextL;
        Node nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

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