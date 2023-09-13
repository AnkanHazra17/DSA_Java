

// Question: Reverse a string using stack


import java.util.Stack;

public class Solution{

    // This method takes a string as input and returns the reverse of that string.
    public static String reverceStringUsingStack(String str){
        // Create a stack to store characters from the input string.
        Stack<Character> charStack = new Stack<>();

        // Initialize an index variable to traverse the input string.
        int ind = 0;

        // Push each character from the input string onto the stack.
        while(ind < str.length()){
            charStack.push(str.charAt(ind));
            ind++;
        }

        // Create a StringBuilder to store the reversed string.
        StringBuilder ans = new StringBuilder("");

        // Pop characters from the stack and append them to the StringBuilder to reverse the string.
        while(!charStack.isEmpty()){
            char res = charStack.pop();
            ans.append(res);
        }

        // Convert the reversed StringBuilder back to a string and return it.
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "Ankan";
        System.out.println(reverceStringUsingStack(str));
    }
}

