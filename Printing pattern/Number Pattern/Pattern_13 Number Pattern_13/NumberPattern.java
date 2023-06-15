

import java.util.Scanner;

public class NumberPattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            int val = i;
            for(int j = 1; j <= i; j++){
                System.out.print(val);
                val += 1;
            }

            int val2 = 2*i - 2;
            for(int j = 1; j <= i - 1; j++){
                System.out.print(val2);
                val2 -= 1;
            }
            System.out.println();
        }
    }
}