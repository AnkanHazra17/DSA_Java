
// Question: Valid Paranthesis 


import java.util.Stack;


public class Solution{

    // This method checks if the given string contains valid pairs of brackets (parentheses, curly braces, and square brackets).
    public static boolean isValidPair(String str){

        // Create a stack to store the opening brackets.
        Stack<Character> st = new Stack<>();

        // Iterate through each character in the input string.
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            // If the character is an opening bracket, push it onto the stack.
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{

                // If the character is a closing bracket:
                // 1. If the stack is empty, there is no matching opening bracket, so return false.
                if(st.isEmpty()){
                    return false;
                }

                // 2. If the character matches the corresponding opening bracket at the top of the stack,
                //    pop the opening bracket from the stack.
                else if((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']')){
                    st.pop();
                }
                else{
                    // 3. If the character does not match the top of the stack, return false.
                    return false;
                }
            }
        }

        // After processing all characters, if the stack is empty, all brackets have been matched and it's valid.
        // Otherwise, there are unmatched opening brackets, so it's invalid.
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({[]}()";
        System.out.println(isValidPair(str));
    }
}

