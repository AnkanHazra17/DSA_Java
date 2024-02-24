
public class Solution {
    public static boolean isSorted(int[] arr, int index, int size) {
        if (size == 0 || size == 1) {
            return true;
        }

        int i = index;
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1, size - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5 };
        int size = arr.length;

        System.out.println(isSorted(arr, 0, size));
    }
}