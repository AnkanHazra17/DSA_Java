

// Question: Given an arrray of n elements, the task is to find the second largest element of the array

import java.util.Arrays;

public class SecondLargestElement{

    // Method to find the second largest element in the array
    static int secondLargest(int[] arr, int n){
        Arrays.sort(arr);  // Sort the array in ascending order
        for(int i = n - 1; i > 0; i--){    // Iterate from the last element to the second element
            if(arr[i] != arr[n - 1]){      // Check if the current element is not equal to the largest element
                return arr[i];    // Return the current element as the second largest
            }
        }
        return -1;    // Return -1 if no second largest element is found
    }

    public static <String> void main(String[] args){
        int[] arr = {6, 7, 4, 5, 3, 5, 9, 11, 2, 3, 4};
        int n = arr.length;
        System.out.println(secondLargest(arr,n)); 
    }
}