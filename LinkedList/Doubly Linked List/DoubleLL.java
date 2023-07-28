


public class DoubleLL{

    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Method to add first of a Doubly Linked List
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Method to add last of a Doubly Linked List
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    // Method to remove first of a Doubly Linked List
    public int removeFirst(){

        if(head == null){
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // Method to remove last of a Linked List
    public int removeLast(){
        if(head == null){
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    // Meyhod to reverse a doubly Linked List
    public void reverse(){
        Node curr = head;
        Node bef = null;
        Node aft;

        while(curr != null){
            aft = curr.next;
            curr.next = bef;
            curr.prev = aft;
            bef = curr;
            curr = aft;
        }

        head = bef;

    }

    // Method to print Doubly Linked List
    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);

        dll.printLL();

        // dll.removeFirst();
        // dll.printLL();

        // dll.removeLast();
        // dll.printLL();

        dll.reverse();
        dll.printLL();
    }
}