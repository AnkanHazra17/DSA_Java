import java.util.Arrays;

public class Solution{

    // Recursive method to find the minimum element in an array
    public static int findMin(int[] arr, int start, int end){
        // Base case: If there is only one element in the subarray, return it
        if(start == end){
            return arr[start];
        }

        // Calculate the middle index of the current subarray
        int mid = start + (end - start)/2;

        // Recursively find the minimum in the left and right subarrays
        int left = findMin(arr, start, mid);
        int right = findMin(arr, mid + 1, end);

        // Return the minimum of the left and right subarray minimums
        return Math.min(left, right);
    }

    // Recursive method to find the maximum element in an array
    public static int findMax(int[] arr, int start, int end){
        // Base case: If there is only one element in the subarray, return it
        if(start == end){
            return arr[start];
        }

        // Calculate the middle index of the current subarray
        int mid = start + (end - start)/2;

        // Recursively find the maximum in the left and right subarrays
        int left = findMax(arr, start, mid);
        int right = findMax(arr, mid + 1, end);

        // Return the maximum of the left and right subarray maximums
        return Math.max(left, right);
    }

    // Find both minimum and maximum in an array
    public static int[] findMinMaxRec(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        // Call the findMin and findMax methods to get the minimum and maximum
        int min = findMin(arr, start, end);
        int max = findMax(arr, start, end);

        // Return the minimum and maximum as an array
        return new int[] {min, max};
    }

    public static void main(String[] args) {
        int[] arr = {2,1, 3, 4};
        System.out.println(Arrays.toString(findMinMaxRec(arr)));
    }
}

