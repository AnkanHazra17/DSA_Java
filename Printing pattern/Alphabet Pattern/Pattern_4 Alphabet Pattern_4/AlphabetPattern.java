

import java.util.Scanner;

public class AlphabetPattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            int ithRow = 'A' + i - 1;
            for(int j = 1; j <= i; j++){
                char jthChar = (char)(ithRow + j - 1);
                System.out.print(jthChar);
            }
            System.out.println();
        }
    }
}