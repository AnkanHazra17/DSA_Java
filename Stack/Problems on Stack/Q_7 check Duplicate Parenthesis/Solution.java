
// Question: Check Duplicate Paranthesis


import java.util.Stack;

public class Solution{

    // Method to check duplicate parenthesis
    public static boolean checkDuplicate(String str){

        // Create a stack of characters
        Stack<Character> st = new Stack<>();

        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++){

            // Get the character at the current position
            char ch = str.charAt(i);
            
            // Check if the character is a closing parenthesis ')'
            if(ch == ')'){
                int cnt = 0;

                // Pop characters from the stack until an opening parenthesis '(' is found
                while(st.pop() != '('){
                    cnt++;   // Count the number of characters popped
                }

                // If the count of characters popped is less than 1, it means there were no matching opening parenthesis
                // in the stack, so return true to indicate a duplicate closing parenthesis
                if(cnt < 1){
                    return true;
                }
            }
            // If the character is not a closing parenthesis, it must be an opening parenthesis '('
            else{
                st.push(ch);  // Push the opening parenthesis onto the stack
            }
        }

        // If the loop completes without finding any duplicate closing parentheses, return false
        return false;
    }

    
    public static void main(String[] args) {
        String str = "(a+b)";
        System.out.println(checkDuplicate(str));
    }
}

