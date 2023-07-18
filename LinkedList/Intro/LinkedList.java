


public class LinkedList{

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

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        // if LinkedList is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // if LinkedList is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        // when linked list is non empty
        tail.next = newNode;
        tail = newNode;
    }

    public void addInMiddle(int ind, int data){

        if(ind == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while(i < ind - 1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void printList(){

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.printList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.printList();

        ll.addInMiddle(2, 5);
        ll.printList();

        System.out.println(ll.size);
    }
}