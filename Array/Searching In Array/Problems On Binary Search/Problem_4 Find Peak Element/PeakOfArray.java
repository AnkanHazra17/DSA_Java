

// Question: Find Peak Element

// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index.
// If the array contains multiple peaks, return the index to any of the peaks.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.



public class PeakOfArray{

    // Method to find the index of a peak element in the array
    static int findPeak(int[] arr){
        int n = arr.length;    // Get the length of the input array

        if(n == 1){     // Check if the array has only one element
            return 0;   // Return 0 as the only element is considered a peak
        }

        // Check if the last element is greater than the second-to-last element
        if(arr[n - 1] > arr[n - 2]){
            return n - 1;  // Return the index of the last element as it's a peak
        }

        // Check if the first element is greater than the second element
        if(arr[0] > arr[1]){
            return 0;    // Return 0 as the first element is considered a peak
        }

        int start = 1;     // Initialize the start index for binary search
        int end = n - 2;   // Initialize the end index for binary search

        // Binary search loop
        while(start <= end){  
            int mid = start + (end - start) / 2;   // Calculate the middle index

            // Check if arr[mid] is a peak
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;    // Return the index of the peak element
            }
            else if(arr[mid] > arr[mid - 1]){  // Check if arr[mid] is greater than its left neighbor
                start = mid + 1;    // Update start index to search on the right side
            }
            else{
                end = mid - 1;   // Update end index to search on the left side
            }
        }

        return -1;  // Return -1 if no peak element is found
    }

    

    public static void main(String[] args){
        int[] arr ={1,2,1,3,5,6,4};
        System.out.println(findPeak(arr));
    }
}