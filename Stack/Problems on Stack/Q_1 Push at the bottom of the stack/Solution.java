

// Question: Push an element in the bottom of the stack

import java.util.Stack;

public class Solution{

    // Function to Push an element in the bottom of the stack
    public static void pushAtBottom(Stack<Integer> st, int data){

        // If the stack is empty, push the data to the bottom of the stack and return
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        // Otherwise, pop the top element of the stack and store it in a variable named top
        int top = st.pop();

        pushAtBottom(st, data); // Recursively call the pushAtBottom method with the same stack and data
        st.push(top);   // Push the top element back to the stack
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);

        pushAtBottom(st, 5);

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}

