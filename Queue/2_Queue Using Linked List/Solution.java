
class QueueWithLinkedList{

    class Node{
        private int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty(){
        return head == null;
    }

    public void add(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return Integer.MIN_VALUE;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek(){
        return head.data;
    }

    public void prinQueue(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Solution{

    public static void main(String[] args) {
        QueueWithLinkedList ql = new QueueWithLinkedList();

        ql.add(1);
        ql.add(2);
        ql.add(3);
        ql.add(4);
        ql.add(5);

        System.out.println(ql.peek());

        ql.prinQueue();

        while(!ql.isEmpty()){
            System.out.println("Removed: " + ql.remove());
        }
    }
}