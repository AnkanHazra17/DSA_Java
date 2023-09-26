

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

    public void printLinkedListRec(Node head){
        Node temp = head;

        if(temp == null){
            return;
        }

        System.out.print(temp.data + " ");
        printLinkedListRec(temp.next);
    }
    
}

public class Solution{

    public static void main(String[] args) {
        LinkedListLL ll = new LinkedListLL();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printLinkedListRec(ll.head);
    }
}