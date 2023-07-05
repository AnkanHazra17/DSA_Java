import java.util.Arrays;
import java.util.Scanner;

public class InputAndPrint{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows");
        int row = sc.nextInt();

        System.out.println("Enter number of cols");
        int cols = sc.nextInt();

        int[][] arr = new int[row][cols];

        System.out.println("Enter Array Elements:");
        // Taking input

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // Printing output: mathod - 1 
        // for(int i = 0; i < row; i++){
        //     for(int j = 0; j < cols; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // Mathod - 2
        for(int i = 0; i < row; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}