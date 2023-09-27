
// Recursive Binary Search

public class Solution{

    public static int binarySearchRec(int[] arr, int target, int start, int end){
        // Base Case
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target){
            return binarySearchRec(arr, target, start, mid - 1);
        }
        else{
            return binarySearchRec(arr, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearchRec(arr, 5, 0, arr.length - 1));
        System.out.println(binarySearchRec(arr, 1, 0, arr.length - 1));
        System.out.println(binarySearchRec(arr, 4, 0, arr.length - 1));
        System.out.println(binarySearchRec(arr, 2, 0, arr.length - 1));
        System.out.println(binarySearchRec(arr, 3, 0, arr.length - 1));
    }
}