
// Q: Check if a string is palindrom or not

import java.util.Scanner;

public class Palindrom{

    static boolean check(String str){
        str = str.toLowerCase();
        int start = 0;
        int end = str.length(); 

        while(start <= end){
            if(str.charAt(start) != str.charAt(end - 1)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(check(str));
    }

}