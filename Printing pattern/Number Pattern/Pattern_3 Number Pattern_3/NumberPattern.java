

import java.util.Scanner;

public class NumberPattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(n - j);
            }
            System.out.println();
        }
    }
}