

// Custom exception class to represent the scenario when the stack is empty
class StackEmptyException extends Exception{

}

// Custom exception class to represent the scenario when the stack is full
class StackFullException extends Exception{

}

// Array-based stack implementation
class ArrStack{
    private int data[];  // Array to store the elements of the stack
    private int top;     // Index of the top element in the stack

    // Default constructor, initializes the stack with a default capacity of 10
    public ArrStack(){
        data = new int[10];
        top = -1;   // Set top to -1 to indicate an empty stack
    }

    // Constructor to create a stack with a specified capacity
    public ArrStack(int capacity){
        data = new int[capacity];
        top = -1;    // Set top to -1 to indicate an empty stack
    }

    // Method to check if the stack is empty
    public boolean isEmpty(){
        // if(top == -1){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        return top == -1;   // Stack is empty when the top index is -1
    }

    // Method to check if the stack is full
    public boolean isFull(){

        // Stack is full when the top index is equal to the length of the array - 1
        return top == data.length - 1;
    }

    // Method to get the current size of the stack
    public int size(){
        return top + 1;   // Size of the stack is the index of the top element + 1
    }

    // Method to get the top element of the stack without removing it
    public int top() throws StackEmptyException{

        // If the stack is empty, throw a custom StackEmptyException
        if(isEmpty()){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        // Otherwise, return the element at the top index
        return data[top];
    }

    // Method to push an element onto the top of the stack
    public void push(int ele) throws StackFullException{

        // If the stack is full, throw a custom StackFullException
        if(isFull()){
            StackFullException e = new StackFullException();
            throw e;
        }

        // Otherwise,
        top++;           // Increment the top index
        data[top] = ele; // Add the element to the stack
    }

    // Method to pop (remove and return) the top element from the stack
    public int pop() throws StackEmptyException{

        // If the stack is empty, throw a custom StackEmptyException
        if(isEmpty()){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        // Otherwise, 
        int val = data[top];  // Get the element at the top index
        top--;                // Decrement the top index
        return val;           // return the element
    }
}

// Main class to demonstrate the stack implementation
public class StackArray{

    public static void main(String[] args) throws StackFullException {

        // Create an instance of the ArrStack class with a default capacity of 10
        ArrStack stack = new ArrStack();

        // Push integers 1 to 5 onto the stack
        for(int i = 1; i<= 5; i++){
            stack.push(i);
        }

        try{
            // Get the top element of the stack and print it without removing it
            System.out.println("Stack Top: " + stack.top());
        }
        catch(StackEmptyException e){

        }

        // Print Size of the stack
        System.out.println("Stack size: " + stack.size());

        // Pop elements from the stack and print them
        while(!stack.isEmpty()){
            try{
                System.out.print(stack.pop() + " ");
            }
            catch(StackEmptyException e){

            }
        }
    }
}