// Question: Given a sentence, the task is to reverse thesentence word wise

public class ReverceSentence{

    // Method to reverse the order of words in a sentence
    static String reverceWordWise(String str){

        String ans = "";  // Variable to store the reversed sentence
         
        int end = str.length() - 1;  // Index of the last character in the input string

        for(int i = end; i >= 0; i--){  // Loop through the characters of the input string in reverse order

            // Check if the current character is a space
            if(str.charAt(i) == ' '){
                int start = i + 1;  // Index of the first character of the word
                String word = "";

                // Extract the word between the start and end indices
                for(int j = start; j <= end; j++){
                    word += str.charAt(j);
                }

                // Append the extracted word to the reversed sentence along with a space
                ans += word + " ";
                end = i - 1;  // Update the end index to the position before the space
            }
        }

        // Extract the remaining word from the start of the sentence to the current end index
        String word = "";
        for(int k = 0; k <= end; k++){
            word += str.charAt(k);
        }

        ans += word + " ";

        return ans;
    }

    public static void main(String[] args) {
        String str = "I am Ankan";
        System.out.println(reverceWordWise(str));
    }
}