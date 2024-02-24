
public class Solution {

    public static int helper(int[] arr, int index, int size, int key) {
        if (size == 0) {
            return -1;
        }

        if (arr[index] == key) {
            return index;
        }

        return helper(arr, index + 1, size - 1, key);
    }

    public static int linearSearch(int[] arr, int key) {
        return helper(arr, 0, arr.length, key);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 8, 3, 1 };
        System.out.println(linearSearch(arr, 12));
    }
}