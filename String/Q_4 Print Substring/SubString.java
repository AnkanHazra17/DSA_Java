

public class SubString{

    // Method to print all substrings character-wise
    static void printSubStringCharWise(String str){

        // Iterate over each character in the string
        for(int start = 0; start < str.length(); start++){

            // Iterate from the current character to the end of the string
            for(int end = start; end < str.length(); end++){

                // Extract the substring from the start index to the end index (inclusive)
                System.out.println(str.substring(start, end + 1));
            }
            
        }
    }

    // Method to print all substrings length-wise
    static void printSubStringLenWise(String str){

        // Iterate over each possible substring length
        for(int len = 1; len <= str.length(); len++){

            // Iterate over each possible starting index of a substring
            for(int start = 0; start <= str.length() - len; start++){

                int end = start + len - 1; // Calculate the end index of the substring        

                // Extract the substring from the start index to the end index (inclusive)
                System.out.println(str.substring(start, end + 1));
            }
            
        }
    }

    public static void main(String[] args) {
        String str1 = "Ankan";
        printSubStringCharWise(str1);
        printSubStringLenWise(str1);
    }
}