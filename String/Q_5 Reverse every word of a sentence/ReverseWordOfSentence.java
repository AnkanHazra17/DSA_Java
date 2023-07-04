// Question: Given a sentence, the task is to reverse every word of the sentence

public class ReverseWordOfSentence{

    // Method to reverse the words in a sentence
    static String reverce(String str){
        int start = 0;  // Starting index of a word
        String ans = "";  // Reversed sentence

        int i;
        for(i = 0; i < str.length(); i++){   // Iterate through the characters of the sentence

            if(str.charAt(i) == ' '){  // Check if a space character is found
                int wordEnd = i - 1;  // Index of the last character of the current word
                String currentWordReverse = "";  // Reversed current word

                // Reverse the current word
                for(int j = start; j <= wordEnd; j++){
                    currentWordReverse = str.charAt(j) + currentWordReverse;
                }

                // Add the reversed word to the result
                ans = ans + currentWordReverse + " ";
                start = i + 1;  // Update the start index for the next word
            }
        }

        // Reverse the last word (since there is no space after it)
        String currentWordReverse = "";
        for(int k = start; k < str.length(); k++){
            currentWordReverse = str.charAt(k) + currentWordReverse + " ";
        }
        ans = ans + currentWordReverse;


        return ans; // Return the reversed sentence
    } 

    public static void main(String[] args) {
        String str = "abc def ghi";
        System.out.println(reverce(str));
    }
}