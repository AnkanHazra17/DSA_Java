

import java.util.Scanner;

public class StarPattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int row = 1; row <= n; row++){
            for(int colSpace = 1; colSpace <= n - row; colSpace++){
                System.out.print(" ");
            }
            for(int colStar = 1; colStar <= row; colStar++){
                System.out.print(colStar);
            }
            System.out.println();
        }
    }
}