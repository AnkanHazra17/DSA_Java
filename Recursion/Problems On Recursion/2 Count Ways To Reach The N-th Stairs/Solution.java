import java.util.Scanner;

public class Solution {
    public static int countDistinctWayToClimbStair(long nStairs) {
        if (nStairs < 0) {
            return 0;
        }

        if (nStairs == 0) {
            return 1;
        }

        return countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countDistinctWayToClimbStair(n));
        sc.close();
    }
}