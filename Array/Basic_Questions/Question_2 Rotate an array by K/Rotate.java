
// Question: Given an array with n elements, the task is to rotare the array to the left or right by k steps, where k is non negative


import java.util.Arrays;

public class Rotate{

    // Helper method to reverse a portion of the array
    static void reverse(int[] arr, int first, int second){
        while(first < second){
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            first++;
            second--;
        }
        
    }

    // Method to rotate the array to the left
    static void leftRotate(int[] arr, int n, int k){
        // Ensure k is within the range of the array length
        k = k % n; 

        reverse(arr, 0,(n - 1));         // Reverse the entire array
        reverse(arr, (n - k), (n - 1));  // Reverse the first (n - k) elements
        reverse(arr, 0, (n - k - 1));    // Reverse the remaining k elements
    }


    // Method to rotate the array to the right
    static void rightRotate(int[] arr, int n, int k){
        // Ensure k is within the range of the array length
        k = k % n;

        reverse(arr, (n - k), (n - 1));  // Reverse the last k elements
        reverse(arr, (0), (n - k - 1));  // Reverse the first (n - k) elements
        reverse(arr, 0, (n - 1));        // Reverse the entire array
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 2;
        leftRotate(arr,n,k);
        System.out.println(Arrays.toString(arr));
        rightRotate(arr,n,k);
        System.out.println(Arrays.toString(arr));
    }
}