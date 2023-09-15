

// Question: Next Grater elements


import java.util.Arrays;
import java.util.Stack;


public class Solution{

    // This method calculates the next greater element for each element in the given array.
    public static int[] nextGraterElements(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nextGrater = new int[arr.length];

        // Iterate through the array in reverse order (from right to left).
        for(int i = arr.length - 1; i >= 0; i--){

            // While the stack is not empty and the current element is greater than or equal to
            // the element at the top of the stack, pop elements from the stack.
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }

            // If the stack is empty after popping elements, it means there are no greater elements
            // to the right of the current element, so set the nextGreater value to -1.
            if(st.isEmpty()){
                nextGrater[i] = -1;
            }

            // If the stack is not empty, the element at the top of the stack is the next greater
            // element to the right of the current element.
            else{
                nextGrater[i] = st.peek();
            }

            // Push the current element onto the stack for future comparisons.
            st.push(arr[i]);
        }

        return nextGrater;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(nextGraterElements(arr))); 
    }
}

