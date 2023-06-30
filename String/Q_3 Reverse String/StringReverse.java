
// Q: Reverse a string

import java.util.Scanner;

public class StringReverse{

    static String reverse(String str){
        String reverseString = "";

        //   * Start from last
        // for(int i = str.length() - 1; i >= 0; i--){
        //     reverseString = reverseString + str.charAt(i); 
        // }

        // * Start from begining
        for(int i = 0; i < str.length(); i++){
            reverseString = str.charAt(i) +  reverseString;
        }

        return reverseString;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        
        System.out.println(reverse(str));
    }
}