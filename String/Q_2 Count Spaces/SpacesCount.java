
// Q: Given a string, Count the numer of spaces in the string

import java.util.Scanner;

public class SpacesCount {

    static int countSpace(String str){
        if(str.length() == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == ' '){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(countSpace(str));
    }
}