
public class Solution {

    public static void sumhelper(int[] arr, int index, int size, int[] sum) {
        if (size == 0) {
            return;
        }
        sum[0] = sum[0] + arr[index];
        sumhelper(arr, index + 1, size - 1, sum);
    }

    public static int arrSum(int[] arr) {
        int size = arr.length;
        int[] sum = new int[1];
        sumhelper(arr, 0, size, sum);
        return sum[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(arrSum(arr));
    }
}