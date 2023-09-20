
// Queue using 2 stack

import java.util.Stack;

class QueueWith2Stack{

    // Create two stacks, s1 and s2, to implement the queue.
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Check if the queue is empty by checking if s1 is empty.
    public boolean isEmpty(){
        return s1.isEmpty();
    }

    // Add an element to the queue.
    public void add(int data){

        // Transfer all elements from s1 to s2 to reverse their order.
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(data);   // Push the new element onto s1.

        // Transfer the elements back from s2 to s1 to maintain the order.
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // Remove and return the front element of the queue.
    public int remove(){

        // Check if the queue is empty.
        if(s1.isEmpty()){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        // Pop and return the front element from s1.
        return s1.pop();
    }

    // Peek at the front element of the queue without removing it.
    public int peek(){

        // Check if the queue is empty.
        if(s1.isEmpty()){
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        // Return the front element from s1.
        return s1.peek();
    }
}

public class Solution{

    public static void main(String[] args) {
        QueueWith2Stack q = new QueueWith2Stack();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}