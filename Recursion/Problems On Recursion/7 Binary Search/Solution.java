
public class Solution {

    public static int binarySearchHelper(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] > key) {
            return binarySearchHelper(arr, start, mid - 1, key);
        } else {
            return binarySearchHelper(arr, mid + 1, end, key);
        }
    }

    public static int binarySearch(int[] arr, int key) {
        return binarySearchHelper(arr, 0, arr.length - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 8, 10 };
        System.out.println(binarySearch(arr, 5));
    }
}