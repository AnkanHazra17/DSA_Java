
public class Solution {
    public static void sayNumbers(int n, String[] digits) {
        if (n <= 0) {
            return;
        }

        int digit = n % 10;
        n = n / 10;

        sayNumbers(n, digits);
        System.out.print(digits[digit] + " ");
    }

    public static void main(String[] args) {
        String[] digits = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
        sayNumbers(410, digits);
    }
}