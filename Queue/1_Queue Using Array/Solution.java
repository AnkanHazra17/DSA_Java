

// Queue Using Array
class QueueWithArray{
    int[] data;     // Declare an integer array to store queue elements.
    int size;       // Store the maximum capacity of the queue.
    int rare;       // Store the index of the rear of the queue.

    // Constructor for the queue
    public QueueWithArray(int n){
        this.data = new int[n];   // Create an array of size 'n' to hold the queue elements.
        this.size = n;            // Set the maximum capacity of the queue.
        this.rare = -1;           // Initialize the rear index to -1 (empty queue).
    }

    // Method to check if the queue is empty or not
    public boolean isEmpty(){
        return rare == -1;     // Check if the rear index is -1, indicating an empty queue.
    }

    // Method to add an element in the queue
    public void add(int ele){
        if(rare == size - 1){
            System.out.println("Queue is full"); // If the rear index is at the last position, the queue is full.
            return;   // Exit the method without adding the element to the queue.
        }

        rare = rare + 1;    // Increment the rear index to make space for the new element.
        data[rare] = ele;   // Add the element to the rear of the queue.
    }

    // Method to remove an element from the queue
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");  // If the queue is empty (rear index is -1), display an error message.
            return Integer.MIN_VALUE;   // Return a special value (Integer.MIN_VALUE) to indicate an error.
        }

        int front = data[0];    // Get the element at the front of the queue.    
        for(int i = 0; i < rare; i++){
            data[i] = data[i + 1];  // Shift all elements one position to the left to remove the front element.
        }
        rare = rare - 1;     // Decrement the rear index to reflect the removal of an element.
        return front;        // Return the removed element from the front of the queue.
    }

    // Method to find peek element from the queue
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");  // If the queue is empty, display an error message.
            return Integer.MIN_VALUE;   // Return a special value to indicate an error.
        }

        return data[0];   // Return the element at the front of the queue without removing it.
    }

}

// Circular Queue implementation Using array
class CircularQueueWithArray{
    int[] data;      // Declare an integer array to store queue elements.
    int size;        // Store the maximum capacity of the circular queue.
    int rare;        // Store the index of the rear of the circular queue.
    int front;       // Store the index of the front of the circular queue.


    // Constructor for the queue
    public CircularQueueWithArray(int n){
        this.data = new int[n];   // Create an array of size 'n' to hold the circular queue elements.
        this.size = n;            // Set the maximum capacity of the circular queue.
        this.rare = -1;           // Initialize the rear index to -1 (empty circular queue).
        this.front = -1;          // Initialize the front index to -1 (empty circular queue).
    }

    public boolean isEmpty(){

        // Check if both the rear and front indices are -1, indicating an empty circular queue.
        return rare == -1 && front == 1;
    }

    public boolean isFull(){

        // Check if the next position after the rear index is equal to the front index, indicating a full circular queue.
        return (rare + 1) % size == front;
    }

    public void add(int ele){
        if(isFull()){
            System.out.println("Queue is full");  // If the circular queue is full, display an error message.
            return;   // Exit the method without adding the element to the circular queue.
        }

        if(front == -1){
            front = 0;   // If the circular queue was previously empty, set the front index to 0.
        }
        rare = (rare + 1) % size;  // Increment the rear index in a circular manner to make space for the new element.
        data[rare] = ele;   // Add the element to the rear of the circular queue.
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");  // If the circular queue is empty, display an error message.
            return Integer.MIN_VALUE;    // Return a special value to indicate an error.
        }

        int val = data[front];   // Get the element at the front of the circular queue.
        
        if(rare == front){

            // If there was only one element in the circular queue, reset both the rear and front indices to -1.
            rare = front = -1;
        }
        else{
            // Increment the front index in a circular manner to remove the front element.
            front = (front + 1) % size;
        }
        return val;  // Return the removed element from the front of the circular queue.
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");  // If the circular queue is empty, display an error message.
            return Integer.MIN_VALUE;   // Return a special value to indicate an error.
        }

        return data[front];  // Return the element at the front of the circular queue without removing it.
    }

}



public class Solution{

    public static void main(String[] args) {
        QueueWithArray q = new QueueWithArray(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);

        System.out.println("Front => " + q.peek());
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }

        System.out.println(q.peek());
    }
}